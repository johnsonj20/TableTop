import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import Services.*;

enum AuthenticationMethod {
  passwordOnly, passwordOTP
}

public class Main {
  public static void main(String[] args) {
    AuthenticationService authenticationService = new AuthenticationService();
    java.io.Console console = System.console();

    String filePath = "Configuration/config.txt";
    String pageLine;
    HashMap<String, String> map = new HashMap<String, String>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      while ((pageLine = reader.readLine()) != null) {
        String[] configLineParts = pageLine.split(":", 2);
        if (configLineParts.length >= 2) {
          String key = configLineParts[0];
          String value = configLineParts[1];
          map.put(key, value);
        } else {
          System.out.println("ignoring line: " + pageLine);
        }
      }
      for (String key : map.keySet()) {
        System.out.println(key + ":" + map.get(key));
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Value below needs to come from config file.
    AuthenticationMethod authenticationMethod = AuthenticationMethod.passwordOTP;

    Boolean authenticated = false;
    String username = console.readLine("Username: ");

    if (authenticationMethod == AuthenticationMethod.passwordOnly) {
      String password = new String(console.readPassword("Password: "));
      boolean authenticatedPassword = authenticationService.authenticateUser_Password(username, password);
      authenticated = authenticatedPassword;
    }

    if (authenticationMethod == AuthenticationMethod.passwordOTP) {
      String passwordOTP = new String(console.readPassword("Password + OTP: "));
      boolean authenticatedPasswordOTP = authenticationService.authenticateUser_PasswordOTP(username, passwordOTP);
      authenticated = authenticatedPasswordOTP;
    }

    if (authenticated) {
      System.out.println("Welcome, " + username + "! You are verified.");
      String getDateTimeResponse = console.readLine(
          "Would you like to display the date in Date only Format(1), Time only Format(2), Date and Time Format(3), or Cached Time(4)? ");
      if (getDateTimeResponse.toLowerCase().equals("1")) {
        GetDateFormat.getDate();
      }
      if (getDateTimeResponse.toLowerCase().equals("2")) {
        GetCurrentTimeFormat.getTime();
      }
      if (getDateTimeResponse.toLowerCase().equals("3")) {
        GetDateTimeFormat.getDateTime();
      }
      if (getDateTimeResponse.toLowerCase().equals("4")) {
        TimeCache.getCachedTime();
      }
    } else {
      System.out.println("Account Not Found");
      restart(args);
    }
  }

  private static void restart(String[] args) {
    main(args);
  }
}
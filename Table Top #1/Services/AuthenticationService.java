package Services;

public class AuthenticationService extends UserCredentials {
    public Boolean authenticateUser_Password(String username, String password) {
        if (username.equals(verifiedUserName) && password.equals(verifiedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean authenticateUser_PasswordOTP(String username, String passwordOTP) {
        if (username.equals(verifiedUserName) && passwordOTP.equals(verifiedPasswordOTP)) {
            return true;
        } else {
            return false;
        }
    }
}

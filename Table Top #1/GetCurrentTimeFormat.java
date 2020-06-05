import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentTimeFormat {
    static Date systemTime = SystemTime.getSystemTime();
    static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss z");

    public static void getTime() {
        System.out.println(formatter.format(systemTime));
    }
}
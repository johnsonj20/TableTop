import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateTimeFormat {
    static Date systemTime = SystemTime.getSystemTime();
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    public static void getDateTime() {
        System.out.println(formatter.format(systemTime));
    }
}
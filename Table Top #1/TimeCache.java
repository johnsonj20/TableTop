import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCache {
    static Date systemTime = SystemTime.getSystemTime();
    static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss z");

    public static void getCachedTime() {
        System.out.println(formatter.format(systemTime));
    }
}
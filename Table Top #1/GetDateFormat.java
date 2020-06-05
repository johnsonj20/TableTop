import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDateFormat {
    static Date systemTime = SystemTime.getSystemTime();
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static void getDate() {
        System.out.println(formatter.format(systemTime));
    }
}
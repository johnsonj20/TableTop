import java.util.Date;

public class SystemTime {
    public static Date getSystemTime() {
        Date dateTime = new Date(System.currentTimeMillis());
        return dateTime;
    }
}
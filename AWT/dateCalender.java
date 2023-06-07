package AWT;
import java.util.*;
public class dateCalender {
    public static void main(String[] args) {
        // this gregoriancalender is used for the time based applications
        GregorianCalendar gc = new GregorianCalendar();
        // System.out.println(gc.isLeapYear(2024));
        // System.out.println(gc.get(Calendar.DAY_OF_MONTH));
        // System.out.println(gc);

        gc.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        TimeZone tz = gc.getTimeZone();
        System.out.println(tz.getID());
    }
}

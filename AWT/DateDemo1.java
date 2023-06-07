package AWT;
import java.time.*;
public class DateDemo1 {
    public static void main(String[] args) {
        // Date obj = new Date();
        // obj.setHours(21);
        // System.out.println(obj);

        // LocalDate d = LocalDate.now(Clock.systemDefaultZone());
        // LocalDate d = LocalDate.now(ZoneId.of("America/Los_Angeles"));
        // LocalDate d = LocalDate.of(2024, Month.APRIL, 21);
        // LocalDate d = LocalDate.ofEpochDay(1);
        // LocalDate d = LocalDate.parse("2023-04-21");
        // LocalDate d1 = d.plusMonths(6);
        // System.out.println(d1);

        // System.out.println(d);


        // LocalTime t = LocalTime.now();
        // System.out.println(t);
        // LocalTime t1 = t.minusHours(3);
        // System.out.println(t1);


        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
    }
}

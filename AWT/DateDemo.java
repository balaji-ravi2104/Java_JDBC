package AWT;
import java.util.*;
public class DateDemo {
    public static void main(String[] args) {
        // System.out.println(System.currentTimeMillis());
        // For printing the years...
        // System.out.println(System.currentTimeMillis()/1000/60/60/24/365);
        // System.out.println(Long.MAX_VALUE);
        
        // Days and month are starts with-> 0..like 0 to 6 for week and 0 t0 11 for month
        Date obj = new Date();
        
        // Since java follows the year from 1900 so while printing the year we have to add 1900
        // System.out.println(obj.getYear()+1900);
        System.out.println(obj);
    }

}

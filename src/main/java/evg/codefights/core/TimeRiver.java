package evg.codefights.core;

import java.text.*;
import java.time.*;
import java.util.*;

public class TimeRiver {

    public static void main(String[] args) {
        System.out.println(new TimeRiver().curiousClock("2016-08-26 22:40", "2016-08-29 10:00"));
        System.out.println(new TimeRiver().curiousClock("2016-08-26 22:40", "2016-08-26 22:41"));
        System.out.println(new TimeRiver().curiousClock("2015-01-14 09:12", "2015-11-04 17:36"));
    }

    boolean validTime(String time) {
        String[] s = time.split(":");
        int hours = Integer.parseInt(s[0]);
        int minutes = Integer.parseInt(s[1]);
        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60;
    }

    int[] videoPart(String part, String total) {
        String[] s = part.split(":");
        String[] t = total.split(":");

        int sumPart = Integer.parseInt(s[0]) * 60 * 60 + Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2]);
        int sumTot = Integer.parseInt(t[0]) * 60 * 60 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
        int gcd = gcd(sumPart, sumTot);

        return new int[]{sumPart / gcd, sumTot / gcd};
    }

    int gcd(int a, int b) {
        int t;
        while (b != 0) {
            t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    int dayOfWeek(String birthdayDate) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy");
        java.time.LocalDate parse = java.time.LocalDate.parse(birthdayDate, formatter);
        String str = birthdayDate.substring(0, birthdayDate.length() - 4);
        int year = parse.getYear();
        java.time.DayOfWeek dayOfWeek = parse.getDayOfWeek();
        boolean leapYear = parse.isLeapYear() && parse.getMonthValue() == 2 && parse.getDayOfMonth() == 29;
        int res = 0;
        while (true) {
            int add = leapYear ? 4 : 1;
            parse = java.time.LocalDate.parse(str + (year + res + add), formatter);
            if (dayOfWeek == parse.getDayOfWeek()) {
                return res + add;
            }
            res += add;
        }
    }

    String curiousClock(String someTime, String leavingTime) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        java.time.LocalDateTime date1 = java.time.LocalDateTime.parse(someTime, formatter);
        java.time.LocalDateTime date2 = java.time.LocalDateTime.parse(leavingTime, formatter);
        java.time.Duration duration = java.time.Duration.between(date2, date1);
        java.time.LocalDateTime res = date1.plus(duration);
        return formatter.format(res);
    }
}

package evg.codefights.core;

import java.time.format.DateTimeFormatter;

public class TimeRiver {

    public static void main(String[] args) {
        System.out.println(new TimeRiver().dayOfWeek("02-29-2072"));
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

}

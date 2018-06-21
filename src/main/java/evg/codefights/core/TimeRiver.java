package evg.codefights.core;

public class TimeRiver {

    public static void main(String[] args) {

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
        while(b != 0){
            t = a;
            a = b;
            b = t%b;
        }
        return a;
    }

}

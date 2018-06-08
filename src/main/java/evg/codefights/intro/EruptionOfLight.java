package evg.codefights.intro;

import java.util.regex.*;
import java.util.stream.IntStream;

public class EruptionOfLight {

    boolean isBeautifulString(String inputString) {
        int[] n = new int[26];
        for(int i = 0; i < inputString.length(); i++) {
            int c = inputString.charAt(i) - 'a';
            n[c]++;
        }
        for(int i = 1; i < n.length; i++) {
            if (n[i -1] < n[i]) {
                return false;
            }
        }
        return true;
    }

    String findEmailDomain(String address) {
        Pattern p = Pattern.compile(".*@([\\w\\.]+)$");
        Matcher m = p.matcher(address);
        if (m.find()) {
            return m.group(1);
        } else {
            return "";
        }
    }

    String buildPalindrome(String st) {
        StringBuilder sb = new StringBuilder();
        int s = 0;
        int rep = 0;
        for(int i = st.length() - 1; i >= 0; ) {
            char end = st.charAt(i);
            if (s == st.length()) {
                if (sb.charAt(sb.length() - 1) == st.charAt(rep)) {
                    rep--;
                }
                for(int j = rep; j >=0; j--) {
                    sb.append(st.charAt(j));
                }
                break;
            }
            char start = st.charAt(s);
            if (start != end) {
                sb.append(start);
                s++;
                rep++;
            } else {
                sb.append(start);
                s++;
                i--;
            }
        }
        return sb.toString();
    }

    int electionsWinners(int[] votes, int k) {
        int max = IntStream.of(votes).max().getAsInt();
        int t = (int)IntStream.of(votes).filter(x -> x + k > max).count();
        if (t != 0) {
            return t;
        } else {
            int s = (int) IntStream.of(votes).filter(x -> x == max).count();
            return s == 1 ? 1 : 0;
        }
    }

    boolean isMAC48Address(String inputString) {
        Pattern p = Pattern.compile("^[A-F\\d][A-F\\d]-[A-F\\d][A-F\\d]-[A-F\\d][A-F\\d]-[A-F\\d][A-F\\d]-[A-F\\d][A-F\\d]-[A-F\\d][A-F\\d]$");
        Matcher m = p.matcher(inputString);
        return m.find();
    }
}

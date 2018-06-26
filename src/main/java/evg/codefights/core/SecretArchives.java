package evg.codefights.core;

import java.util.Arrays;
import java.util.regex.*;
import java.util.stream.Collectors;

public class SecretArchives {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SecretArchives().lrc2subRip(new String[] {"[00:09.01]",
                "[00:10.01] Sweet dreams are made of this",
                "[00:13.26] Who am I to disagree?",
                "[00:17.01] Travel the world and the seven seas",
                "[00:20.95] Everybodys looking for something",
                "[00:24.57]",
                "[00:24.82] Some of them want to use you",
                "[00:28.64] Some of them want to get used by you",
                "[00:32.45] Some of them want to abuse you",
                "[00:36.32] Some of them want to be abused",
                "[00:40.32]",
                "[00:52.00] Sweet dreams are made of this",
                "[00:55.37] Who am I to disagree?",
                "[00:59.18] Travel the world and the seven seas",
                "[01:03.00] Everybodys looking for something",
                "[01:48.34] Some of them want to use you",
                "[01:52.16] Some of them want to get used by you",
                "[01:55.97] Some of them want to abuse you",
                "[01:59.72] Some of them want to be abused",
                "[02:03.58]",
                "[01:18.17]",
                "[01:29.17] Hold your head up, movin on",
                "[01:19.18] Hold your head up",
                "[01:31.11] Keep your head up",
                "[01:19.92] Keep your head up, movin on",
                "[01:21.86] Hold your head up, movin on",
                "[01:23.74] Keep your head up, movin on",
                "[01:25.67] Hold your head up, movin on",
                "[01:27.55] Keep your head up, movin on"}, "00:09:32")));
    }

    String[] lrc2subRip(String[] lrcLyrics, String songLength) {
    Pattern pattern = Pattern.compile("^\\[(\\d{2})\\:(\\d{2})\\.(\\d{2})\\]\\s*(.*)$");
    Pattern songLen = Pattern.compile("^(\\d{2})\\:(\\d{2})\\:(\\d{2})$");
    Matcher matcher = songLen.matcher(songLength);
    matcher.find();
    int HH = Integer.parseInt(matcher.group(1));
    int MM = Integer.parseInt(matcher.group(2));
    int SS = Integer.parseInt(matcher.group(3));
    int xxx = 0;
    String[] res = new String[lrcLyrics.length * 3 + lrcLyrics.length - 1];
    for(int i = lrcLyrics.length - 1; i >= 0; i--) {
        Matcher mat = pattern.matcher(lrcLyrics[i]);
        mat.find();
        int m = Integer.parseInt(mat.group(1));
        int s = Integer.parseInt(mat.group(2));
        int x = Integer.parseInt(mat.group(3)) * 10;
        int h = 0;
        if (m > 59) {
            h = 1;
            m = m % 60;
        }
        String str = mat.group(4);

        res[i * 4] = Integer.toString(i + 1);
        res[i * 4 + 1] = String.format("%02d:%02d:%02d,%03d --> %02d:%02d:%02d,%03d", h, m, s, x, HH, MM, SS, xxx);
        res[i * 4 + 2] = str;
        if (i != lrcLyrics.length - 1) {
            res[i * 4 + 3] = "";
        }
        HH = h;
        MM = m;
        SS = s;
        xxx = x;
    }
    return res;
    }

}

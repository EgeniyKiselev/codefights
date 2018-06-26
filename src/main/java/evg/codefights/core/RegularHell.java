package evg.codefights.core;

import java.util.regex.*;

public class RegularHell {

    public static void main(String[] args) {
        System.out.println(new RegularHell().eyeRhyme("cough\tbough"));
    }

    boolean isSentenceCorrect(String sentence) {
        String regex = "^[A-Z]+[^\\.\\?\\!]*[\\.\\?\\!]$";
        return sentence.matches(regex);
    }

    String replaceAllDigitsRegExp(String input) {
        return input.replaceAll("\\d", "#");
    }


    String swapAdjacentWords(String s) {
        return s.replaceAll("(\\b\\w+) (\\w*\\b)", "$2 $1");
    }

    String nthNumber(String s, int n) {
        Pattern pattern = Pattern.compile("(?:[\\D0]+)*(?:\\d+[\\D0]+){" + (n - 1) + "}(\\d+).*");

        Matcher matcher = pattern.matcher(s);
        matcher.matches();
        return matcher.group(1);
    }

    boolean isSubsequence(String t, String s) {
        String pattern = "";
        for (int i = 0; i < s.length(); i++) {
            pattern += "[\\w\\W]*" + Pattern.quote("" + s.charAt(i));
        }
        Pattern regex = Pattern.compile(pattern);
        System.out.println(regex);
        return regex.matcher(t).find();
    }

    Boolean eyeRhyme(String pairOfLines) {
        Pattern pattern = Pattern.compile("^.*(.{3})\t.*(.{3})$");
        Matcher matcher = pattern.matcher(pairOfLines);
        matcher.matches();
        return matcher.group(1).equals(matcher.group(2));
    }


}

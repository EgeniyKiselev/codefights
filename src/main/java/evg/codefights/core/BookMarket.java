package evg.codefights.core;

public class BookMarket {

    String encloseInBrackets(String inputString) {
        return "(" + inputString + ")";
    }

    String properNounCorrection(String noun) {
        return noun.substring(0, 1).toUpperCase() + noun.substring(1).toLowerCase();
    }

    boolean isTandemRepeat(String inputString) {
        if (inputString.length() % 2 != 0) {
            return false;
        }
        int i = 0;
        int j = inputString.length() / 2;
        for (; j < inputString.length(); i++, j++) {
            if (inputString.charAt(i) != inputString.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    boolean isCaseInsensitivePalindrome(String inputString) {
        String str = inputString.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    String findEmailDomain(String address) {
        return address.substring(address.lastIndexOf("@") + 1);
    }

    String htmlEndTagByStartTag(String startTag) {
        StringBuilder sb = new StringBuilder();
        sb.append("</");
        boolean isAdd = false;
        for (int i = 0; i < startTag.length(); i++) {
            if (startTag.charAt(i) == '<') {
                isAdd = true;
            } else if (isAdd) {
                if (startTag.charAt(i) == ' ') {
                    sb.append('>');
                    break;
                }
                sb.append(startTag.charAt(i));
            }
        }
        return sb.toString();

    }

    boolean isMAC48Address(String inputString) {
        return inputString.matches("((\\d|[A-F]){2})(-(\\d|[A-F]){2}){5}");
    }

    boolean isUnstablePair(String filename1, String filename2) {
        int comp1 = filename1.compareTo(filename2);
        int comp2 = filename1.toLowerCase().compareToIgnoreCase(filename2.toLowerCase());
        return !(comp1 > 0 && comp2 > 0 || comp1 < 0 && comp2 < 0 || comp1 == 0 && comp2 == 0);
    }


}

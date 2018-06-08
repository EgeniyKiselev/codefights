package evg.codefights.intro;

import java.util.regex.Pattern;

public class RainsOfReason {

    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for(int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }
        }
        return inputArray;
    }

    boolean evenDigitsOnly(int n) {
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            if (d % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    boolean variableName(String name) {
        Pattern p = Pattern.compile("^([a-zA-Z_])(\\w*)$");
        return p.matcher(name).find();
    }

    String alphabeticShift(String inputString) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            int d = ((c - 'a') + 1) % 26;
            sb.append((char)('a' + d));
        }

        return sb.toString();
    }

    boolean chessBoardCellColor(String cell1, String cell2) {
        int x1 = cell1.charAt(0) - 'A';
        int y1 = cell1.charAt(1) - '1';

        int x2 = cell2.charAt(0) - 'A';
        int y2 = cell2.charAt(1) - '1';

        return getColor(x1, y1) == getColor(x2, y2);

    }

    boolean getColor(int x, int y) {
        return x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0;
    }



}

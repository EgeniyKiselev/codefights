package evg.codefights.core;

import java.math.BigInteger;
import java.util.*;

public class LabOfTransformations {

    String characterParity(char symbol) {
        if (Character.isDigit(symbol)) {
            return (symbol - '0') % 2 == 0 ? "even" : "odd";
        } else {
            return "not a digit";
        }
    }

    String reflectString(String inputString) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            char n = (char)('z' - (c - 'a'));
            sb.append(n);
        }
        return sb.toString();
    }

    String[] newNumeralSystem(char number) {
        int k = number - 'A';
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= 25; i++) {
            for(int j = i; j <= 25; j++) {
                if (i + j == k) {
                    list.add(new Character((char)(i + 'A')) + " + " + new Character((char)(j + 'A')));
                }
            }
        }
        return list.toArray(new String[0]);
    }

    String cipher26(String message) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < message.length(); i++) {
            int c = message.charAt(i) - 'a';
            int r = (c - sum)  % 26;
            if (r < 0) {
                r += 26;
            }
            sum += r;
            char res = (char) (r + 'a');
            sb.append(res);
        }
        return sb.toString();
    }

    String stolenLunch(String note) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < note.length(); i++) {
            char ch = note.charAt(i);
            if (Character.isDigit(ch)) {
                int dif = ch - '0';
                sb.append((char)('a' + dif));
            } else {
                int dif = ch - 'a';
                if (dif < 10 && dif >= 0) {
                    sb.append((char)('0' + dif));
                } else {
                    sb.append(ch);
                }

            }
        }
        return sb.toString();
    }

    boolean higherVersion(String ver1, String ver2) {
        String s1[] = ver1.split("\\.");
        String s2[] = ver2.split("\\.");
        for(int i = 0; i < s1.length; i++) {
            int l = Integer.parseInt(s1[i]);
            int r = Integer.parseInt(s2[i]);
            if (l > r) {
                return true;
            } else if (l < r) {
                return false;
            }
        }
        return false;
    }

    String decipher(String cipher) {
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cipher.length(); i++) {
            int t = cipher.charAt(i) - '0';
            c = c * 10 + t;
            if (Character.isAlphabetic(c)) {
                sb.append((char)c);
                c = 0;
            }
        }
        return sb.toString();
    }

    boolean alphanumericLess(String s1, String s2) {
        List<Token> left = getTokens(s1);
        List<Token> righ = getTokens(s2);
        for(int i = 0; i < left.size(); i++) {
            Token l = left.get(i);
            if (i == righ.size()) {
                return true;
            }
            Token r = righ.get(i);
            if (l.compareTo(r) < 0) {
                return true;
            } else if (l.compareTo(r) > 0) {
                if (l.isNumber && r.isNumber) {
                    BigInteger leftNumber = new BigInteger(l.number);
                    BigInteger rightNumber = new BigInteger(r.number);
                    if (leftNumber.equals(rightNumber)) {
                        continue;
                    }
                }
                return false;
            }
        }
        return left.size() < righ.size();
    }

    List<Token> getTokens(String s) {
        List<Token> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();) {
            while(i < s.length() && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.length() != 0) {
                list.add(new Token(sb.toString()));
                sb.setLength(0);
            }
            while(i < s.length() && !Character.isDigit(s.charAt(i))) {
                list.add(new Token(s.charAt(i)));
                i++;
            }
        }
        return list;
    }

    static class Token  implements Comparable<Token> {
        char ch;
        String number;
        final boolean isNumber;

        public Token(char ch) {
            this.ch = ch;
            isNumber = false;
        }

        public Token(String number) {
            this.number = number;
            isNumber = true;
        }

        @Override
        public int compareTo(Token o) {
            if (isNumber && o.isNumber) {
                BigInteger thisNum = new BigInteger(number);
                BigInteger otherNum = new BigInteger(o.number);
                if (thisNum.equals(otherNum)) {
                    return o.number.length() - number.length();
                } else {
                    return thisNum.compareTo(otherNum);
                }
            }
            if (isNumber) return -1;
            if (o.isNumber) return 1;
            return ch - o.ch;
        }

        public String toString() {
            return new StringJoiner(", ", Token.class.getSimpleName() + "[", "]")
                    .add("ch=" + ch)
                    .add("number='" + number + "'")
                    .add("isNumber=" + isNumber)
                    .toString();
        }
    }



}

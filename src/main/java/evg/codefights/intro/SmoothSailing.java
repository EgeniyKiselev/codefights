package evg.codefights.intro;

import java.util.Stack;

public class SmoothSailing {

    public static void main(String[] args) {

    }

    String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                int left = stack.pop();
                int l = left;
                int r = i;
                while (l < r) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                    l++; r--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] != '(' && chars[i] != ')') {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }

}

import java.util.*;

public class Solution2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char operation = '+';
        int tmpSum = 0;
        int len = s.length();
        int curr = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == len - 1) {
                if (operation == '+') {
                    sum += tmpSum;
                    tmpSum = curr;
                } else if (operation == '-') {
                    sum += tmpSum;
                    tmpSum = -curr;
                } else if (operation == '*') {
                    tmpSum *= curr;
                } else if (operation == '/') {
                    tmpSum /= curr;
                }
                operation = c;
                curr = 0;
            }
        }
        sum += tmpSum;
        return sum;
    }

    public static void main(String args[]) {
        Solution2 sol = new Solution2();
    }
}

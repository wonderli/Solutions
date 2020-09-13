import java.util.*;

public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();
        Stack<String> number = new Stack<>();
        number.push("#");
        char[] cArray = s.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if (Character.isDigit(c)) {
                number.push(Character.toString(c));
            } else if (c == '[') {
                stack.push(Character.toString(c));
                number.push("#");
            } else if (c == ']') {
                StringBuilder nsb = new StringBuilder();
                number.pop();
                while(!number.isEmpty() && !(number.peek().equals("#"))){
                    nsb.append(number.pop());
                }
                int n = Integer.parseInt(nsb.reverse().toString());
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && (!stack.peek().equals("["))) {
                    sb.append(stack.pop());
                }
                stack.pop();
                String s1 = build(n, sb.toString());
                stack.push(s1);
            } else {
                stack.push(Character.toString(c));
            }
        }
        StringBuilder ret = new StringBuilder();
        while(!stack.isEmpty()){
            ret.append(stack.pop());
        }
        return ret.reverse().toString();
    }


    private String build(int n, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
//        String s = "3[a]2[bc]";
//        System.out.println(sol.decodeString(s));
        System.out.println(sol.decodeString("3[a2[c]]"));
//        System.out.println(sol.decodeString("2[abc]3[cd]ef"));
//        System.out.println(sol.decodeString("abc3[cd]xyz"));
//        System.out.println(sol.decodeString("100[leetcode]"));
    }
}


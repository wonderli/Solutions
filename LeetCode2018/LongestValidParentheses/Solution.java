import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        stack.push(-1);
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

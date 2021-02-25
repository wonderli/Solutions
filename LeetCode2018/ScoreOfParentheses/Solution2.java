import java.util.*;
class Solution2 {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stack = new ArrayDeque<>();
        int curr = 0;
        stack.push(curr);
        for(char c : S.toCharArray()){
            if(c == '('){
                stack.push(0);
            }else{
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}

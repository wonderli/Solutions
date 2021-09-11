import java.util.*;
class Solution {
    public int calculate(String s) {
        int n = s.length();
        int curr = 0;
        int lastSign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + (c - '0');
            }else if(c == '+'){
                result +=  lastSign * curr;
                curr = 0;
                lastSign = 1;
            }else if(c == '-'){
                result += lastSign * curr;
                curr = 0;
                lastSign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(lastSign);
                result = 0;
                lastSign = 1;
            }else if(c == ')'){
                result += lastSign * curr;
                curr = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(curr != 0) result += lastSign * curr;
        return result;
        
    }
}

import java.util.*;
public class Solution{
    public boolean isValid(String s) {
        if(s == null||s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(isMatch(stack.peek(), s.charAt(i))) stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
    public boolean isMatch(char a, char b){
        if(a == '(' && b == ')') return true;
        if(a == '{' && b == '}') return true;
        if(a == '[' && b == ']') return true;
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

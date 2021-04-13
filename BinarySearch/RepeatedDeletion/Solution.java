import java.util.*;

class Solution {
    public String solve(String s) {
        if(s.length() <= 1) return s;
        int n = s.length();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while(i < n){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c){
                char x = stack.pop();
                while(i < n && x == s.charAt(i)){
                    i++;
                }
                i--;
            }else{
                stack.push(c);
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
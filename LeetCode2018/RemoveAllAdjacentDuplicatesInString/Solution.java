import java.util.*;
public class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = S.length();
        for(int i = 0; i < n; i++){
            char c = S.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
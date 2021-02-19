import java.util.*;
public class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    indexToRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < s.length(); i++){
            if(!indexToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

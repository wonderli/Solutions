import java.util.*;
public class Solution{
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurance = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            lastOccurance.put(s.charAt(i), i);
        }

        for(int i =0; i <s.length(); i++){
            char c = s.charAt(i);
            if(!seen.contains(c)){
                while(!stack.isEmpty() && c < stack.peek() && lastOccurance.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
	            seen.add(c);
	            stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

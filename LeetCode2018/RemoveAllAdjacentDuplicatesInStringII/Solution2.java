import java.util.*;
public class Solution2 {
    private class Pair{
        int count;
        char c;
        public Pair(char c, int count){
            this.count = count;
            this.c = c;
        }
    }
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(stack.isEmpty() || stack.peek().c != s.charAt(i)){
                stack.push(new Pair(s.charAt(i), 1));
            }else{
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            for(int i = 0; i < p.count; i++){
                sb.append(p.c);
            }
        }
        return sb.reverse().toString();
    }
}

import java.util.*;
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] s = logs.get(0).split(":");
        stack.push(Integer.valueOf(s[0]));
        int prev = Integer.valueOf(s[2]);
        for(int i = 1; i < logs.size(); i++){
            s = logs.get(i).split(":");
            if(s[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += Integer.valueOf(s[2]) - prev;
                }
                stack.push(Integer.valueOf(s[0]));
                prev = Integer.valueOf(s[2]);
            }else{
                result[stack.peek()] += Integer.valueOf(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.valueOf(s[2])+1;
            }
        }
        return result;
    }
}
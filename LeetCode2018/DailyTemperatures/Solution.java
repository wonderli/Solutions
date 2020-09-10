import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = T.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ret;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(sol.dailyTemperatures(T)));
    }
}
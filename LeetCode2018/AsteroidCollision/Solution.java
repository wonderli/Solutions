import java.util.*;
public class Solution{
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length <= 1) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for(int e : asteroids){
            if(e > 0){
                stack.push(e);
            }else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(e)){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(e);
                }else if(stack.peek() == Math.abs(e)){
                    stack.pop();
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

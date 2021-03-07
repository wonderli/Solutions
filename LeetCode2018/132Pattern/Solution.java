import java.util.*;
public class Solution{
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i-1], nums[i]);
        }
        for(int j = nums.length - 1; j >=0;j--){
            if(nums[j] > min[j]){
                while(!stack.isEmpty() && stack.peek() <= min[j]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[j]){
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {1, 2, 3, 4};
        System.out.println(sol.find132pattern(a));
        int[] b = {3, 1, 4, 2};
        System.out.println(sol.find132pattern(b));
        int[] c = {-1, 3, 2, 0};
        System.out.println(sol.find132pattern(c));

    }
}

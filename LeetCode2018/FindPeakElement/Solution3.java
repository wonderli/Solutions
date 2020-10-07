import java.util.*;
public class Solution3{
    public int findPeakElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < nums.length; i++){
           long a = (stack.peek() == -1) ? Long.MIN_VALUE : (long)nums[stack.peek()];
           if((long)nums[i] < a){
               return stack.peek();
           }else{
               stack.push(i);
           }
        }
        long b = stack.peek() == -1 ? Long.MIN_VALUE : (long)nums[stack.peek()];
        if(b > Long.MIN_VALUE){
            return nums.length - 1;
        }
        return -1;
    }
}

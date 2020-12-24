import java.util.*;
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]){
                result[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        
        return result;
    }
}

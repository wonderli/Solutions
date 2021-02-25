import java.util.*;
class Solution3 {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int l = n;
        int r = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int j = n-1; j >= 0; j--){
            while(!stack.isEmpty() && nums[j] > nums[stack.peek()]){
                r = Math.max(r, stack.pop());
            }
            stack.push(j);
        }
        return r - l > 0? r - l + 1 : 0;
    }
}

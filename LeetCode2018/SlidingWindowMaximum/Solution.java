import java.util.*;
public class Solution{
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> index = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for(int i= 0;i < nums.length; i++){
            while(!index.isEmpty() && nums[index.peekLast()] <= nums[i]){
                index.pollLast();
            }
            index.add(i);
            if(i >= k - 1){
                if(!index.isEmpty() && index.peekFirst() <= i - k){
                    index.pollFirst();
                }
                res[i - k + 1] = nums[index.peekFirst()];
            }
        }

        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a= {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(sol.maxSlidingWindow(a, 3)));
    }
}

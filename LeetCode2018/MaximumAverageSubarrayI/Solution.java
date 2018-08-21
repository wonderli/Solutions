import java.util.*;
public class Solution{
    public double findMaxAverage(int[] nums, int k) {
        if(k == 0||nums == null) return 0;
        int len = nums.length;
        double max = 0;
        for(int i = 0; i < k; i++){
            max += nums[i];
        }
        double cur = max;
        for(int i = 1; i <= len - k; i++) {
           cur = cur - nums[i-1] + nums[i + k -1];
           max = cur > max ? cur : max;
        }
        return max/k;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int nums[] = {1,12,-5,-6,50,3};
        //int nums[] = {0,4,0,3,2};
        //int nums[] = {4};
        //int nums[] = {-1};
        int nums[] = {0,1,1,3,3};
        System.out.println(sol.findMaxAverage(nums, 4));
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

import java.util.*;
public class Solution2{
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int mid = l + (h - l)/2;
            if(mid % 2 == 1) mid--;
            if(nums[mid] == nums[mid+1]){
                l = mid + 2;
            }else {
                h = mid;
            }
        }
        return nums[l];
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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

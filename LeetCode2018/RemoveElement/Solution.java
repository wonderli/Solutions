import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {3,2,2,3};
        System.out.println(sol.removeElement(a, 3));
        int[] b = {0,1,2,2,3,0,4,2};
        System.out.println(sol.removeElement(b, 2));
    }
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int i = -1;
        int j = 0;
        while(j < len) {
            if(nums[j] == val){
                j++;
            }else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        return i+1;
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

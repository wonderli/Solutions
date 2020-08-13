import java.util.*;
public class Solution{
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(j < nums.length && i < nums.length){
            if(nums[j] != val){
                j++;
            }else{
                swap(nums, i, j);
                i++;
				j++;
            }
        }
        return i + 1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {3, 2, 2, 3};
        System.out.println(sol.removeElement(nums, 3));
        int[] a = {0,1,2,2,3,0,4,2};
        System.out.println(sol.removeElement(a, 2));

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

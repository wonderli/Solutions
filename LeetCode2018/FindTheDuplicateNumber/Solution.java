import java.util.*;
public class Solution{
    public int findDuplicate(int[] nums) {
        int i = nums[0];
        int j = nums[0];
        do{
            i = nums[i];
            j = nums[nums[j]];
        }while( i != j);

        i = nums[0];
        while(i != j){
            i = nums[i];
            j = nums[j];
        }
        return j;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] n = {1, 3, 4, 2, 2};
        System.out.print(sol.findDuplicate(n));
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

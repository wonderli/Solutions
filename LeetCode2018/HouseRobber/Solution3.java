import java.util.*;
public class Solution3{
    public int rob(int[] nums){
        int prevMax = 0;
        int currMax = 0;
        for(int i : nums){
            int tmp = currMax;
            currMax = Math.max(prevMax + i, currMax);
            prevMax = tmp;
        }
        return currMax;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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

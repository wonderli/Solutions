import java.util.*;
public class Solution2{
    public int closestValue(TreeNode root, double target){
        int a = root.val;
        TreeNode next = target < a ? root.left : root.right;
        if(next == null) return a;
        int b = closestValue(next, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
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

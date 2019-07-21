import java.util.*;
public class Solution{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if((s == null && t != null)|| (s != null && t == null)) return false;
        return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if((s == null && t != null)|| (s != null && t == null)) return false;
        return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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

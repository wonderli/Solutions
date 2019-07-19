import java.util.*;
public class Solution{
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        int val = root.val;
        if(set.contains(k - val)) return true;
        set.add(val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(sol.findTarget(root, 9));
        System.out.println(sol.findTarget(root, 28));
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

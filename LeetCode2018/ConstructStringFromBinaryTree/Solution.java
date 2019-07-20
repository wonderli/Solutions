import java.util.*;
public class Solution{
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        int val = t.val;
        StringBuilder sb = new StringBuilder();
        if(t.left == null && t.right == null){
            sb.append(val);
            return sb.toString();
        }
        sb.append(val);
        String left = tree2str(t.left);
        String right = tree2str(t.right);
            sb.append("(");
            sb.append(left);
            sb.append(")");
            if(right != ""){
                sb.append("(");
                sb.append(right);
                sb.append(")");
            }
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(sol.tree2str(root));
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

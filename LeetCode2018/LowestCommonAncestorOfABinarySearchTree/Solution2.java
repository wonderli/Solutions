import java.util.*;
public class Solution2{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val  && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

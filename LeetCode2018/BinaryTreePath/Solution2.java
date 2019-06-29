import java.util.*;
public class Solution2{
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String curr = new String();
        btp(result, curr, root);
        return result;
    }
    public void btp(List<String> result, String curr, TreeNode root){
        if(root == null){
            return;
        }
        curr = curr + root.val;
        if(root.left == null && root.right == null){
            result.add(curr);
            return;
        }
        btp(result, curr + "->", root.left);
        btp(result, curr + "->", root.right);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.right = new TreeNode(5);
        System.out.println(sol.binaryTreePaths(n));
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

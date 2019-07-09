import java.util.*;
public class Solution2{
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(node != null){
                int value = node.val;
                if(value == val){
                    return node;
                }else if(value < val){
                    stack.push(node.right);
                }else{
                    stack.push(node.left);
                }
            }
        }
        return null;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(sol.searchBST(root, 2));
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

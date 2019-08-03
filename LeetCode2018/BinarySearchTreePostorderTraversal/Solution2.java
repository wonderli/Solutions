import java.util.*;
public class Solution2{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if((prev == null) || (prev.left == curr) || (prev.right == curr)){
                if(curr.left != null){
                    stack.push(curr.left);
                }else if(curr.right != null){
                    stack.push(curr.right);
                }
            }else if(curr.left == prev){
                if(curr.right != null) stack.push(curr.right);

            }else {
                ret.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(sol.postorderTraversal(root));
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

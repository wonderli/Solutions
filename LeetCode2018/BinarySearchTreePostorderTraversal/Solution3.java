import java.util.*;
public class Solution3{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr.right == null || curr.right == prev){
                ret.add(curr.val);
                prev = curr;
                curr = null;
            }else{
                stack.push(curr);
                curr = curr.right;
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
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

import java.util.*;
public class Solution2{
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        Integer prev = null;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev != null && prev >= curr.val){
                    return false;
            }
            prev = curr.val;
            res.add(curr.val);
            curr = curr.right;
        }
        return true;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(sol.isValidBST(root));
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

import java.util.*;
public class Solution2{
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if(L <= node.val && node.val <= R){
                    ans += node.val;
                }
                if(L < node.val){
                    stack.push(node.left);
                }
                if(node.val < R){
                    stack.push(node.right);
                }
            }
        }
        return ans;
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

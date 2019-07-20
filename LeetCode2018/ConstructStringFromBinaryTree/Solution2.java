import java.util.*;
public class Solution2{
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(visited.contains(curr)){
                stack.pop();
                sb.append(")");
            }else {
                visited.add(curr);
                sb.append("(" + curr.val);
                if(curr.left == null && curr.right != null){
                    sb.append("()");
                }
                if(curr.right != null){
                    stack.push(curr.right);
                }
                if(curr.left != null){
                    stack.push(curr.left);
                }

            }

        }
        return sb.substring(1, sb.length() - 1);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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

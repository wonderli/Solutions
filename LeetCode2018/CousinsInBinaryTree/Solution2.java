import java.util.*;
public class Solution2{
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        if(x == y) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x){
                        return false;
                    }
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return false;
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

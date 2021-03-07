import java.util.*;
public class Solution{
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count = count + size;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                TreeNode left = curr.left;
                if(left != null){
                    queue.add(left);
                }
                TreeNode right = curr.right;
                if(right != null){
                    queue.add(right);
                }
            }
        }
        return count;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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

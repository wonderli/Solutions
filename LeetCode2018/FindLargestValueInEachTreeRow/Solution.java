import java.util.*;
public class Solution{
     public List<Integer> largestValues(TreeNode root) {
         List<Integer> ret = new ArrayList<>();
         if(root == null) return ret;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             int max = Integer.MIN_VALUE;
             for(int i = 0; i < size; i++){
                 TreeNode n = queue.poll();
                 int val = n.val;
                 max = Math.max(max, val);
                 if(n.left != null) {
                     queue.add(n.left);
                 }
                 if(n.right != null){
                     queue.add(n.right);
                 }
             }
             ret.add(max);
         }
         return ret;
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

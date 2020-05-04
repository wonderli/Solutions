import java.util.*;
public class Solution{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> curr = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                curr.add(n.val);
                TreeNode left = n.left;
                if(left != null){
                    q.add(n.left);
                }
                TreeNode right = n.right;
                if(right != null) {
                    q.add(n.right);
                }
            }
            ret.add(curr);
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

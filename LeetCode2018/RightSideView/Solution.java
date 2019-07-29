import java.util.*;
public class Solution{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode tmp = queue.getLast();
            ret.add(tmp.val);
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if(left != null){
                    queue.add(left);
                }
                if(right != null){
                    queue.add(right);
                }
            }
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

import java.util.*;
public class Solution2{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ret = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            List<Integer> currLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode n = queue.poll();
                currLevel.add(n.val);
                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }
            }
            ret.add(0, currLevel);
        }
        return ret;
    }
    public static void main(String args[]){
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

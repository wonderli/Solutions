import java.util.*;
public class Solution{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);
        while(curr.size() > 0){
            List<Integer> currLevel = new ArrayList<>();
            Queue<TreeNode> next = new LinkedList<>();
            for(TreeNode n : curr){
                currLevel.add(n != null ? n.val : null);
                if(n.left != null){
                    next.add(n.left);
                }
                if(n.right != null) {
                    next.add(n.right);
                }
            }
            curr = next;
            ret.add(currLevel);
        }
        Collections.reverse(ret);
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

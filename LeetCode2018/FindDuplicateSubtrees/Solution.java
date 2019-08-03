import java.util.*;
public class Solution{
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ret  = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return ret;
        helper(root);
        return ret;
    }
    public String helper(TreeNode root){
        if(root == null) return "#";
        String s = root.val + "," + helper(root.left) + "," + helper(root.right);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if(map.get(s) == 2){
            ret.add(root);
        }
        return s;
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

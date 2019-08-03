import java.util.*;
public class Solution{
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root, sum, curr, ret);
        return ret;
    }
    public void helper(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> list){
        if(root == null) return;
        if(sum == root.val && root.left == null && root.right == null){
            curr.add(root.val);
            list.add(curr);
            return;
        }
        List<Integer> left = new ArrayList<>(curr);
        left.add(root.val);
        helper(root.left, sum - root.val, left, list);
        List<Integer> right = new ArrayList<>(curr);
        right.add(root.val);
        helper(root.right, sum - root.val, right, list);
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

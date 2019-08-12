import java.util.*;
public class Solution{
    int max = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        List<Integer> list = new ArrayList<>();
        helper(root, 0, 1, list);
        return max;
    }
    public void helper(TreeNode root, int depth, int index, List<Integer> list){
        if(root == null) return;
        if(depth == list.size()){
            list.add(index);
        }
        max = Math.max(max, index+1-list.get(depth));
        helper(root.left, depth + 1, index * 2, list);
        helper(root.right, depth + 1, index * 2 + 1, list);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        System.out.println(sol.widthOfBinaryTree(root));
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

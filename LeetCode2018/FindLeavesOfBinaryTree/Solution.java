import java.util.*;
public class Solution{
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return ret;
        while(root.left != null || root.right != null){
            helper(root, null);
            ret.add(list);
            list = new ArrayList<>();
        }
        list.add(root.val);
        ret.add(list);
        return ret;
    }
    public void helper(TreeNode root, TreeNode parent){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            if(parent != null){
                if(parent.left == root){
                    parent.left = null;
                }else if(parent.right == root){
                    parent.right = null;
                }
            }
            return;
        }
        helper(root.left, root);
        helper(root.right, root);
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> res = sol.findLeaves(root);
        for(List<Integer> l : res){
            System.out.println(l);
        }
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

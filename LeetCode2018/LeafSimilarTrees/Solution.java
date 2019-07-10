import java.util.*;
public class Solution{
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        leafSequence(root1, r1);
        List<Integer> r2 = new ArrayList<>();
        leafSequence(root2, r2);
        if(r1.size() != r2.size()){
            return false;
        }
        for(int i = 0; i < r1.size(); i++){
            int r1v = r1.get(i);
            int r2v = r2.get(i);
            if(r1v != r2v) return false;
        }
        return true;
    }
    public void leafSequence(TreeNode root, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        leafSequence(root.left, list);
        leafSequence(root.right, list);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        List<Integer> list = new ArrayList<>();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        sol.leafSequence(root, list);
        System.out.println(list);
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

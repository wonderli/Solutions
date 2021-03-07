import java.util.*;
public class Solution{
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return new ArrayList<>();
        return helper(1, n);
    }
    public List<TreeNode> helper(int start ,int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end) {
            ans.add(null);
        }else if(start == end){
            ans.add(new TreeNode(start));
        }else {
            for(int i = start; i <= end; i++){
                List<TreeNode> left = helper(start, i - 1);
                List<TreeNode> right = helper(i + 1, end);
                for(TreeNode leftNode : left){
                    for(TreeNode rightNode : right){
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        List<TreeNode> ans = sol.generateTrees(3);
        for(TreeNode n : ans){
            sol.print(n);
            System.out.println("======new tree=====");
        }
    }
    public void print(TreeNode root){
        if(root == null) return;
        System.out.print(root.val);
        print(root.left);
        print(root.right);
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

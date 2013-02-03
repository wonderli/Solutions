// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        helper(root, sum, a, ret);
        return ret;
    }
    public void helper(TreeNode root, int sum, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> ans){
        if(root == null) return;
        if(root.left == null && root.right == null && sum - root.val == 0){
            a.add(root.val);
            ans.add(a);
            return;
        }
        if(root.left == null && root.right == null && sum - root.val != 0){
            return;
        }
        ArrayList<Integer> left = new ArrayList<Integer>(a);
        left.add(root.val);
        helper(root.left, sum - root.val, left, ans);
        ArrayList<Integer> right = new ArrayList<Integer>(a);
        right.add(root.val);
        helper(root.right, sum - root.val, right, ans);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

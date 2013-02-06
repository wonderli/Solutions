// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
import java.util.*;
public class Solution2{
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null) return ret;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        helper(root, sum, curr, ret);
        return ret;
    }
    public void helper(TreeNode root, int sum, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ret){
        if(root == null) return;
        if(root.left == null && root.right == null && sum - root.val == 0){
            curr.add(root.val);
            ret.add(curr);
            return;
        }
        if(root.left == null && root.right == null && sum - root.val != 0){
            return;
        }
        curr.add(root.val);
        ArrayList<Integer> left = new ArrayList<Integer>(curr);
        ArrayList<Integer> right = new ArrayList<Integer>(curr);
        helper(root.left, sum - root.val, left, ret);
        helper(root.right, sum - root.val, right, ret);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

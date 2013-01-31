//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below. 
import java.util.*;
public class Solution{
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(n == 0) {
            ret.add(null);
            return ret;
        }
            ret = helper(1, n);
        return ret;
    }
    public ArrayList<TreeNode> helper(int l, int r){
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(l > r){
            ret.add(null);
        }else if(l == r){
            ret.add(new TreeNode(l));
        }else if(l < r){
            for(int i = l; i <= r; i++){
                ArrayList<TreeNode> left = helper(l, i - 1);
                ArrayList<TreeNode> right = helper(i + 1, r);
                for(TreeNode le : left){
                    for(TreeNode re : right){
                        TreeNode root = new TreeNode(i);
                        root.left = le;
                        root.right = re;
                        ret.add(root);
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

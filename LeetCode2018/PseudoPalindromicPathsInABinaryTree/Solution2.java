import java.util.*;
public class Solution2{
	int result = 0;
	    public int pseudoPalindromicPaths (TreeNode root) {
	        if(root == null) return 0;
	        int[] count = new int[10];
	        helper(root, count);
	        return result;
	    }
	    private void helper(TreeNode root, int[] count){
	        if(root == null) return;
	        if(root.left == null && root.right == null){
	            count[root.val]++;
	            int cnt = 0;
	            for(int e : count){
	                if(e%2 == 1){
	                    cnt++;
	                }
	            }
	            if(cnt <= 1){
	                result++;
	            }
	            count[root.val]--;
	            return;
	        }
	        count[root.val]++;
	        helper(root.left, count);
	        helper(root.right, count);
	        count[root.val]--;
	    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
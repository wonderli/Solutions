import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        TreeNode curr = null;
        TreeNode root = null;
        int num = 0;
        int multiplier = 1;
        int n = s.length();
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = 10 * num + Character.getNumericValue(c);
                if(i == n-1 || !Character.isDigit(s.charAt(i+1))){
                    curr = new TreeNode(num * multiplier);
                    num = 0;
                    multiplier = 1;
                    addCurrToParent(curr, stack);
                    stack.push(curr);
                    if(root == null) root = curr;
                }
            }else if(c == ')'){
                stack.pop();
            }else if(c == '-'){
                multiplier = -1;
            }
        }
        return root;
    }
    
    private void addCurrToParent(TreeNode curr, Stack<TreeNode> stack){
        if(stack.isEmpty())  return;
        TreeNode parent = stack.peek();
        if(parent.left == null){
            parent.left = curr;
        }else{
            parent.right = curr;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}

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
        if(s == null || s.length() == 0){
            return null;
        }
        int first = s.indexOf('(');
        int val = first == -1 ? Integer.valueOf(s) : Integer.valueOf(s.substring(0, first));
        TreeNode root = new TreeNode(val);
        if(first == -1){
            return root;
        }
        String left = find(s, first);
        root.left = str2tree(left);
        
        String right = find(s, first + 1 + left.length()+1);
        root.right = str2tree(right);
        return root;
    }
    private String find(String s, int start){
        int left = 0;
        for(int i = start; i <s.length(); i++){
            if(s.charAt(i) =='('){
                left++;
            }else if(s.charAt(i) == ')'){
                left--;
            }
            if(left == 0){
                return s.substring(start+1, i);
            }
        }
        return "";
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
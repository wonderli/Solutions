import java.util.*;
class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if(root == null || u == null) return null;
        if(root == u) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode prev = null;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(prev == u){
                    return curr;
                }
                if(curr == u){
                    prev = curr;
                }
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return null;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}
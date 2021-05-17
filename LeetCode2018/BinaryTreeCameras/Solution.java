import java.util.*;
class Solution {
    int result = 0;
    Set<TreeNode> covered = new HashSet<>();
    public int minCameraCover(TreeNode root) {
        covered.add(null);
        dfs(root, null);
        return result;
    }
    
    private void dfs(TreeNode node, TreeNode parent){
        if(node != null){
            dfs(node.left, node);
            dfs(node.right, node);
            if((parent == null && !covered.contains(node)) || !covered.contains(node.left)||!covered.contains(node.right)){
                result++;
                covered.add(node);
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
            }
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
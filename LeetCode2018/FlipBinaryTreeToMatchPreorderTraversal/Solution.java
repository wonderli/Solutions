import java.util.*;

class Solution {
    List<Integer> result = new ArrayList<>();
    int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? result : Arrays.asList(-1);
    }
    private boolean dfs(TreeNode root, int[] voyage){
        if(root == null) return true;
        if(root.val != voyage[index]) return false;
        index++;
        if(root.left != null && root.left.val != voyage[index]){
            result.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}

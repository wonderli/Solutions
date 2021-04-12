import java.util.*;
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        int currSum = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            currSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null){
                    currSum += curr.val;
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return currSum;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}

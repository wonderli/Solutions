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
import java.util.*;
class Solution2 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root== null) return new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> leaves = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.add(curr.left);
                    map.put(curr.left, curr);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                    map.put(curr.right, curr);
                }
                if(curr.left == null && curr.right == null){
                    leaves.add(curr);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!leaves.isEmpty()){
            int size = leaves.size();
            Set<TreeNode> parents = new HashSet<>();
            List<Integer> currVals = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = leaves.poll();
                currVals.add(curr.val);
                
                TreeNode parent = map.get(curr);
                if(parent == null) continue;
                if(parent.left == curr){
                    parent.left = null;
                }
                if(parent.right == curr){
                    parent.right = null;
                }
                if(parent.left == null && parent.right == null){
                    leaves.add(parent);
                }
            }
            result.add(currVals);
        }
        return result;
        
    }
}
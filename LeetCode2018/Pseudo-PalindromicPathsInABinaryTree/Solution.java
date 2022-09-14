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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        return count;
    }
    private void helper(TreeNode root, Map<Integer, Integer> map){
        if(root == null) return;
        if(root.left == null && root.right == null){
            map.put(root.val, map.getOrDefault(root.val, 0)+1);
            if(check(map)){
                count++;
            }
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        helper(root.left, new HashMap<>(map));
        helper(root.right, new HashMap<>(map));
    }
    private boolean check(Map<Integer, Integer> map){
        int odd = 0;
        int even = 0;
        for(int key : map.keySet()){
            int v = map.get(key);
            if(v % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return odd == 1 || odd == 0;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}


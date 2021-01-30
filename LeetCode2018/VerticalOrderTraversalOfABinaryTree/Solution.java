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
    
    
    private class Node{
        TreeNode node;
        int x;
        int y;
        int level;
        public Node(TreeNode node, int x, int y, int level){
            this.node = node;
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.add(new Node(root, 0, 0, level));
        int min = 0;
        int max = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                if(curr.x < min){
                    min = curr.x;
                }
                if(curr.x > max){
                    max = curr.x;
                }
                map.computeIfAbsent(curr.x, (k -> new ArrayList<>())).add(curr);
                if(curr.node.left != null){
                    queue.add(new Node(curr.node.left, curr.x - 1, curr.y - 1, level));
                }
                if(curr.node.right != null){
                    queue.add(new Node(curr.node.right, curr.x + 1, curr.y - 1, level));
                }
            }
            level++;
        }
        
        List<List<Integer>> result = getResult(map, min, max);
        return result;
    }
    
    private List<List<Integer>>  getResult(Map<Integer, List<Node>> map, int min, int max){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = min; i<=max;i++){
            List<Node> l = map.get(i);
            Collections.sort(l, (a, b)-> (a.level == b.level? a.node.val - b.node.val : a.level - b.level));
            List<Integer> res = getResult(l);
            result.add(res);
        }
        return result;
    }
    private List<Integer> getResult(List<Node> list){
        List<Integer> res = new ArrayList<>();
        for(Node n : list){
            res.add(n.node.val);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int x) { val = x; }
}


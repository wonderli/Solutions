import java.util.*;
public class Solution{

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> queue = new LinkedList<>();
        helper(root, target, queue, k);
        return new ArrayList<>(queue);
    }
    private void helper(TreeNode root, double target, Queue<Integer> queue, int k){
        if(root == null) return;
        helper(root.left, target, queue, k);
        int val = root.val;
        if(queue.isEmpty()||queue.size() < k){
            queue.add(val);
        }else {
            double distance = getDistance(val, target);
            double d = getDistance(queue.peek(), target);

            if(distance < d){
                queue.add(val);
                if(queue.size() > k){
                    queue.poll();
                }
            }
        }
        helper(root.right, target, queue, k);
    }

    private double getDistance(int val, double target){
        double d = (double)val;
        return Math.abs(d - target);
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

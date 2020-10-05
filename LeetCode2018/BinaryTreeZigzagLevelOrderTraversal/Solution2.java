import java.util.*;
public class Solution2{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                list.add(curr.val);
                if(left != null) queue.add(left);
                if(right != null) queue.add(right);
            }
            if(!leftToRight){
                Collections.reverse(list);
            }
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

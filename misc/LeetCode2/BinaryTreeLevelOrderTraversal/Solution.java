import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode e = queue.poll();
            curr.add(e.val);
            if(e.left != null){
                next.add(e.left);
            }
            if(e.right != null){
                next.add(e.right);
            }
            if(queue.isEmpty()){
                queue = next;
                ret.add(curr);
                curr = new ArrayList<Integer>();
                next = new LinkedList<TreeNode>();
            }
        }
        return ret;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

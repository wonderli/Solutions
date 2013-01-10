import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        curr.add(root);
        while(curr.size() != 0){
            TreeNode node = curr.poll();
            tmp.add(node.val);
            if(node.left != null){
                next.add(node.left);
            }
            if(node.right != null){
                next.add(node.right);
            }
            if(curr.size() == 0){
                curr = next;
                next = new LinkedList<TreeNode>();
                ret.add(tmp);
                tmp = new ArrayList<Integer>();
            }
        }
        return ret;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> ret = s.levelOrder(root);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }

    }
}

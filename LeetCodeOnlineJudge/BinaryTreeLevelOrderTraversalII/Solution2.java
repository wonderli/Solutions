import java.util.*;
public class Solution2{
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null) return ret;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = size - 1; i >= 0; i--){
                TreeNode n = q.poll();
                tmp.add(n.val);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            ret.add(tmp);
        }
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<ArrayList<Integer>>();
        for(int i = ret.size() - 1; i >= 0; i--){
            reverse.add(ret.get(i));
        }
        return reverse;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution2 s = new Solution2();
        ArrayList<ArrayList<Integer>> ret = s.levelOrderBottom(root);
        for(ArrayList<Integer> e : ret){
            System.out.println(e);
        }

    }
}

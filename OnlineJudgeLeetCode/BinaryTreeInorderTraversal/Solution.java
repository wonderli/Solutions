import java.util.*;
public class Solution{
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode prev = null;
        while(!s.empty() || curr != null){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }else{
                curr = s.pop();
                ret.add(curr.val);
                curr = curr.right;
            }
        }
        return ret;
    }
    public static void main(String args[]){
    }
}

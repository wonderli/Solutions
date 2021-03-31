import java.util.*;
public class Solution{
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ret1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currResult = new ArrayList<Integer>();
        currLevel.add(root);
        while(!currLevel.isEmpty()){
            TreeNode r = currLevel.poll();
            currResult.add(r.val);
            if(r.left != null) nextLevel.add(r.left);
            if(r.right != null) nextLevel.add(r.right);
            if(currLevel.isEmpty()){
                ret1.add(currResult);
                currResult = new ArrayList<Integer>();
                currLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
            }
        }
        for(int i = ret1.size() - 1; i >= 0; i--){
            ret.add(ret1.get(i));
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

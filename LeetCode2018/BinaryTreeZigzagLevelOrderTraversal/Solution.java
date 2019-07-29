import java.util.*;
public class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        boolean leftToRight = true;
        while(!list.isEmpty()){
            List<Integer> currLevel = new ArrayList<Integer>();
            List<TreeNode> next = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                TreeNode curr = list.get(i);
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if(leftToRight){
                    if(left != null){
                        next.add(curr.left);
                    }
                    if(right != null){
                        next.add(curr.right);
                    }
                }else {
                    if(right != null){
                        next.add(curr.right);
                    }
                    if(left != null){
                        next.add(curr.left);
                    }
                }
                currLevel.add(curr.val);
            }
            ret.add(currLevel);
            Collections.reverse(next);
            leftToRight = !leftToRight;
            list = next;
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

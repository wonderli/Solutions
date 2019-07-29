import java.util.*;
public class Solution2{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return list;
    }
    public void helper(TreeNode root, List<Integer> list, int depth){
        if(root == null) return;
        if(list.size() == depth){
            list.add(root.val);
        }
        helper(root.right, list, depth+1);
        helper(root.left, list, depth+1);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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

import java.util.*;
public class Solution2{
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode node){
        if(node == null) return min;
        getMinimumDifference(node.left);

        if(prev != null){
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        getMinimumDifference(node.right);
        return min;
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

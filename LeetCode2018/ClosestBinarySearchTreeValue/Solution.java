import java.util.*;
public class Solution{
    public int closestValue(TreeNode root, double target) {
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        closestValue(root, target, result);
        return result.get(0);
    }
    public void closestValue(TreeNode root, double target, List<Integer> result){
        if(root == null) return;
        int curr = root.val;
        int res = result.get(0);
        double distCurr = Math.abs(target - (double)curr);
        double distRes = Math.abs(target - (double)res);
        int value = distCurr < distRes ? curr : res;
        result.clear();
        result.add(value);
        closestValue(root.left, target, result);
        closestValue(root.right, target, result);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
       // TreeNode n = new TreeNode(4);
       // n.left = new TreeNode(2);
       // n.right = new TreeNode(5);
       // n.left.left = new TreeNode(1);
       // n.left.right = new TreeNode(3);
        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(2);
        System.out.println(sol.closestValue(n, 3.714286));
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

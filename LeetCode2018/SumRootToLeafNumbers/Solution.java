import java.util.*;
public class Solution{
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0);
        return sum(list);
    }
    public void helper(TreeNode root, List<Integer> list, int num){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            num = num * 10 + root.val;
            list.add(num);
            return;
        }
        num = num * 10 + root.val;

        helper(root.left, list, num);
        helper(root.right, list, num);
    }
    public int sum(List<Integer> list){
        int ret = 0;
        for(Integer e : list){
            ret += e;
        }
        return ret;
    }
    
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sol.sumNumbers(root));
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

import java.util.*;
public class Solution{
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getList(root, list);
        int a = list.get(0);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            int b = list.get(i);
            min = Math.min(Math.abs(a - b), min);
            a = b;
        }
        return min;
    }
    public void getList(TreeNode root, List<Integer> list){
        if(root == null) return;
        getList(root.left, list);
        list.add(root.val);
        getList(root.right, list);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);
        List<Integer> list = new ArrayList<>();
        sol.getList(node, list);
        System.out.println(list);
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

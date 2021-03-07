import java.util.*;
public class Solution{
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return rebuild(list);
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public TreeNode rebuild(List<Integer> list){
        if(list.size() == 0) return null;
        TreeNode head = new TreeNode(list.get(0));
        TreeNode root = head;
        for(int i = 1; i < list.size(); i++){
            root.left = null;
            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
        return head;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        
        List<TreeNode> list = new ArrayList<>();
        sol.inorder(root, list);
        for(TreeNode n : list){
            System.out.println(n.val);
        }
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

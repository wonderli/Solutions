import java.util.*;
public class Solution{
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        if(x == y) return false;
        Map<Integer, TreeInfo> map = new HashMap<>();
        construct(root, null, 0, map);
        TreeInfo left = map.get(x);
        TreeInfo right = map.get(y);
        return (left != null && right != null) && (left.parent != right.parent) && (left.depth == right.depth);

    }
    public void construct(TreeNode root, TreeNode parent, int depth, Map<Integer, TreeInfo> map){
        if(root == null) return;
        TreeInfo ti = new TreeInfo(root, parent, depth);
        map.put(root.val, ti);
        construct(root.left, root, depth+1, map);
        construct(root.right, root, depth+1, map);
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TreeInfo {
    TreeNode parent;
    TreeNode current;
    int depth;
    public TreeInfo(TreeNode current, TreeNode parent, int depth){
        this.current = current;
        this.parent = parent;
        this.depth = depth;
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

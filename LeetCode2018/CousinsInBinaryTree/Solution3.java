import java.util.*;
public class Solution3{
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Map<Integer, TreeInfo> map = new HashMap<>();
        TreeInfo rootInfo = new TreeInfo(null, 0);
        construct(root, null, 0, map);
        TreeInfo xNode = map.get(x);
        TreeInfo yNode = map.get(y);
        return (xNode != null && yNode != null) && (xNode.parent != yNode.parent) && (xNode.depth == yNode.depth);
    }
    public void construct(TreeNode root, TreeNode parent, int depth, Map<Integer, TreeInfo> map){
        if(root == null) return;
        TreeInfo treeInfo = new TreeInfo(parent, depth);
        map.put(root.val, treeInfo);
        construct(root.left, root,depth+1, map);
        construct(root.right, root, depth+1, map);
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class TreeInfo {
    TreeNode parent;
    int depth;
    TreeInfo(TreeNode n, int depth){
        this.parent = n;
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

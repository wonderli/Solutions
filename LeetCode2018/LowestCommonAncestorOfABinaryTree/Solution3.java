import java.util.*;
public class Solution3{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.add(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = queue.poll();
            if(node != null){
                parent.put(node.left, node);
                parent.put(node.right, node);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = parent.get(p);
        }
        while(!set.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

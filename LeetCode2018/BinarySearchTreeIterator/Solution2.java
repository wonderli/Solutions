import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false
    }
}
class BSTIterator {

    private TreeNode curr;
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.curr = root;
        stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = null;
        if(hasNext()){
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            next = stack.pop();
            curr = next.right;
        }
        return next.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();

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

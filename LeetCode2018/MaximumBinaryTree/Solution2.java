import java.util.*;
public class Solution2{
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode left = null;
        for(int num : nums){
            TreeNode curr = new TreeNode(num);
            while(!deque.isEmpty() && deque.peekFirst().val < curr.val){
                curr.left = deque.pop();
            }
            if(!deque.isEmpty()){
                deque.peekFirst().right = curr;
            }
            deque.push(curr);
        }
        return deque.peekLast();
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

import java.util.*;
public class Solution2{
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if(n == 0) return ret;
        helper(n, n, "", ret);
        return ret;
    }
    public void helper(int left, int right, String curr, List<String> ret){
        if(left < 0 || left > right) return;
        if(left == 0 && right == 0){
            ret.add(curr);
            return;
        }
        helper(left - 1, right, curr + "(", ret);
        helper(left, right - 1, curr + ")", ret);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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

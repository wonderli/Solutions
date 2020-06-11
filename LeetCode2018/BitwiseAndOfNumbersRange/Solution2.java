import java.util.*;
public class Solution2{
    public int rangeBitwiseAnd(int m, int n) {
        while(m < n){
            n = n & (n -1);
        }
        return m & n;
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

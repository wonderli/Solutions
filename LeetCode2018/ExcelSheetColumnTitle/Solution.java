import java.util.*;
public class Solution{
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.append((char)('A' + n%26));
            n = n/26;
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(28));
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

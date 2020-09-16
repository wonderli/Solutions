import java.util.*;
public class Solution{
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i>=0){
            StringBuilder t = new StringBuilder();
            while(i >= 0 && s.charAt(i) != ' '){
                t.append(s.charAt(i));
                i--;
            }
            t.reverse();
            sb.append(t);
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
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

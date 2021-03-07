import java.util.*;
public class Solution{
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        if(p.isEmpty()) return s.isEmpty() ? true: false;
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')); 
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2))|| (firstMatch && isMatch(s.substring(1), p));
        }else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(sol.isMatch(s, p));
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

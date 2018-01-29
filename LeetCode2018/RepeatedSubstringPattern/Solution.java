import java.util.*;
public class Solution{
    public boolean repeatedSubstringPattern(String s) {
        if(s == null||s.length() < 2) return false;
        int len = s.length();
        for(int i = 1; i < len; i++){
            String sub = s.substring(0, i);
            if(check(s, sub)) return true;
        }
        return false;
    }
    public boolean check(String s, String sub){
        int sLen = s.length();
        int subLen = sub.length();
        if(sLen%subLen != 0) return false; 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sLen/subLen; i++){
            sb.append(sub);
        }
        return s.equals(sb.toString());
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        //String a = "abab";
        //String a = "aba";
        String a = "abcabcabcabc";
        System.out.println(sol.repeatedSubstringPattern(a));
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

import java.util.*;
public class Solution2{
    public boolean isAnagram(String s, String t) {
        if((s == null && t != null) || (s != null && t == null)) return false;
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen) return false;
        int[] table = new int[26];
        for(int i = 0; i < sLen; i++){
            table[s.charAt(i) - 'a']++; 
        }
        for(int i = 0; i < tLen; i++){
            table[t.charAt(i) - 'a']--;
            if(table[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(sol.isAnagram(s, t));
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

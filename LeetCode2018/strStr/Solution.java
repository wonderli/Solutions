import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        String haystack = "hello", needle = "ll";
        System.out.println(sol.strStr(haystack, needle));
        haystack = "aaaaa";
        needle = "bba";
        haystack = "";
        needle = "a";
        haystack = "mississippi";
        needle = "issip";
        System.out.println(sol.strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {
        if(haystack == null) return 0;
        if(needle == null || needle.length() == 0) return 0;
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
            if(j == needle.length()){
                return i - needle.length();
            }
        }
        return -1;
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

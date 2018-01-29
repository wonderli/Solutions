import java.util.*;
public class Solution{

    public int strStr(String haystack, String needle) {
        if(haystack == null||needle == null) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int i = 0;
        int j = 0;
        int pos = -1;
        while(i < h.length && j < n.length){
            if(h[i] == n[j]){
                j++;
                pos = i;
            }else {
                i = i - j;
                j = 0;
            }
            i++;
        }
        if(j == n.length) return i - n.length;
        return -1;

    }

    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.strStr("hello", "ll"));
        System.out.println(sol.strStr("hello", "o"));
        System.out.println(sol.strStr("", ""));
        System.out.println(sol.strStr("mississippi", "issip"));
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

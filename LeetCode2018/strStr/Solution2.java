import java.util.*;
public class Solution2{
    public int strStr(String haystack, String needle) {
        if( needle == null || haystack == null) return -1;
        if(needle.length() > haystack.length()) return -1;
        int i = 0;
        int j = 0;
        int start = 0;
        while(i < needle.length() && j < haystack.length()){
            if(needle.charAt(i) == haystack.charAt(j)){
                i++;
                j++;
            }else{
                i = 0;
                start++;
                j = start;
            }
            if(i == needle.length()) return start;
        }
        if(i == needle.length()) return start;
        return -1;

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

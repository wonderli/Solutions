import java.util.*;
public class Solution{
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        char[] c = s.toCharArray();
        int ret = 0;
        int currRunLength = 1;
        int prevRunLength = 0;
        for(int i = 1; i < len; i++){
            if(c[i] == c[i-1]) currRunLength++;
            else{
                prevRunLength = currRunLength;
                currRunLength = 1;
            }
            if(prevRunLength >= currRunLength) ret++;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //String s = "00110011";
        String s = "1";
        System.out.println(sol.countBinarySubstrings(s));
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

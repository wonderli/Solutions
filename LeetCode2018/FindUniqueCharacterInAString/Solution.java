import java.util.*;
public class Solution{
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] map = new int[256];
        int len = s.length();
        for(int i = 0; i < len; i++){
            map[s.charAt(i)]++;
        }
        for(int i = 0; i < len; i++){
            if(map[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "leetcode";
        System.out.println(sol.firstUniqChar(s));
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

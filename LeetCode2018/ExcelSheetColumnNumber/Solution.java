import java.util.*;
public class Solution{
    public int titleToNumber(String s) {
        char[] carr = s.toCharArray();
        int ret = 0;
        for(int i = 0; i < carr.length; i++){
            ret = ret * 26 + (carr[i] - 'A' + 1);
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.titleToNumber("A"));
        System.out.println(sol.titleToNumber("AB"));
        System.out.println(sol.titleToNumber("ZY"));
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

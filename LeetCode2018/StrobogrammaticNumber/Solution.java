import java.util.*;
public class Solution{
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        int i = 0;
        int j = len -1;
        while(i <= j){
            char s1 = num.charAt(i);
            char s2 = num.charAt(j);
            if((s1 == '6' && s2 == '9') || (s1 == '9' && s2 == '6') || (s1 == '8' && s2 == '8') || (s1 == '0' && s2 == '0') || (s1 == '1' && s2 == '1')){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.isStrobogrammatic("1"));
        System.out.println(sol.isStrobogrammatic("69"));
        System.out.println(sol.isStrobogrammatic("88"));
        System.out.println(sol.isStrobogrammatic("181"));
        System.out.println(sol.isStrobogrammatic("1881"));
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

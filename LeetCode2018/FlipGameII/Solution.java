import java.util.*;
public class Solution{
    public boolean canWin(String s) {
        if(s == null || s.length() < 2)
            return false;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.startsWith("++", i)){
                String t = s.substring(0, i) + "--" + s.substring(i+2);
                if(!canWin(t)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "++++-";
        System.out.println(sol.canWin(s));
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

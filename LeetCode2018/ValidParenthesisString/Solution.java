import java.util.*;
public class Solution{
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                min++;
                max++;
            }else if(c == ')'){
                max--;
                min = Math.max(min - 1, 0);
            }else {
                max++;
                min = Math.max(min - 1, 0);
            }
            if(max < 0) return false;
        }

        return min == 0;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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

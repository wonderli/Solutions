import java.util.*;
public class Solution2{
    public boolean isPalindrome(int x){
        if(x < 0 || (x%10 == 0 && x != 0)){
            return false;
        }
        int reverseNumber = 0;
        while(x > reverseNumber){
            reverseNumber = reverseNumber * 10 + x%10;
            x = x /10;
        }

        return x == reverseNumber || x == reverseNumber/10;
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

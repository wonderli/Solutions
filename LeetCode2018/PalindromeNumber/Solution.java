import java.util.*;
public class Solution{
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int base = getBase(x);
        while(x != 0){
            int left = x/base;
            int right = x%10;
            if(left != right){
                return false;
            }
            x = (x - x/base * base - x%10)/10;
            base = base/100;
        }
        return true;
    }

    public int getBase(int x){
        int base = 1;
        while(x > 9){
            x = x/10;
            base = base * 10;
        }
        return base;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //System.out.println(sol.isPalindrome(121));
        //System.out.println(sol.isPalindrome(10));
        //System.out.println(sol.isPalindrome(345543));
        System.out.println(sol.isPalindrome(1000000001));
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

import java.util.*;
public class Solution{
    public int addDigits(int num) {
        if(num /10 == 0) return num;
        int ret = 0;
        while(num != 0){
            int curr = num%10;
            ret += curr;
            num = num /10;
        }

        return addDigits(ret);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.addDigits(38));
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

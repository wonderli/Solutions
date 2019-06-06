import java.util.*;
public class Solution{
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        if(n == 5) return 1;
        return count(n); 
    }
    public int count(int n){
        int i = 0;
        while(n > 0){
            i += n/5;
            n = n/5;
            
        }
        return i;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.count(25));
        System.out.println(sol.trailingZeroes(13));
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

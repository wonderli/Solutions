import java.util.*;
public class Solution{
    public int hammingWeight(int n) {
        int ret = 0;
        while(n != 0){
            n = n & (n-1);
            ret++;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.hammingWeight(411));
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

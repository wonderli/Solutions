import java.util.*;
public class Solution{
    public int reverseBits(int n) {
        int ret = 0;
        for(int i = 0; i < 32; i++){
            ret = ret << 1 | (n & 1);
            n = n >> 1;
        }
        return ret;
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

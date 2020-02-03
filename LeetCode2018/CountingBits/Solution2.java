import java.util.*;
public class Solution2{
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        while(b <= num){
            while(i < b &&  i + b <= num){
                ans[i + b] = ans[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return ans;
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

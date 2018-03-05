import java.util.*;
public class Solution{
    public int powerMod(int a, int b, int mod){
        int ret = 1;
        for(int i = 0; i < b; i++){
            ret = (ret * a)%mod;
        }
        return ret;
    }
    public int superPow(int a, int[] b) {
        if(b == null|| b.length == 0) return 1;
        int len = b.length;
        int ret = 1;
        a = a % 1337;
        for(int i = 0; i < len; i++){
            ret = (powerMod(ret, 10, 1337) * powerMod(a, b[i], 1337)) % 1337;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] b = new int[3];
        b[0] = 2;
        b[1] = 0;
        b[2] = 0;
        System.out.println(sol.superPow(2147483647,b));
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

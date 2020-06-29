import java.util.*;
public class Solution3{
    public boolean isPerfectSquare(int num) {
        long res = (long) num;
        long l = 0;
        long r = num;
        while(l <= r){
            long mid = l + (r - l)/2;
            if(mid * mid == res){
                return true;
            }else if(mid * mid < res){
                l = mid+1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Solution3 sol = new Solution3();
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

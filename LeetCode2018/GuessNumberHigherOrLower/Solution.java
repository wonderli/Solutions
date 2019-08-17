import java.util.*;
public class Solution{
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while(l <= n){
            int mid = l + (r - l)/2;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) < 0){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public int guess(int n){
        return 0;
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

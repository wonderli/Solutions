import java.util.*;
public class Solution3{
    public boolean isPerfectSquare(int num){
        if(num == 0 || num == 1) return true;
        long l = 0;
        long r = num;
        while(l <= r){
            long mid = l + (r - l)/2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                l = mid + 1;
            }else {
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
    ListNode(int x, ListNode n){ val = x; next = n;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

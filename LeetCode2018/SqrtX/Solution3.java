import java.util.*;
public class Solution3{
    public int mySqrt(int x){
        if(x < 2) return x;
        int l = 0;
        int r = x;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(mid < x/mid){
                l = mid + 1;
            }else if(mid > x/mid){
                r = mid - 1;
            }else if(mid == x/mid){
                return mid;
            }
        }
        return r;
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

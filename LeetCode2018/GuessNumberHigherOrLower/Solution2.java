import java.util.*;
public class Solution2{
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(guess(mid) < 0){
                r = mid - 1;
            }else if(guess(mid) > 0){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return r;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
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

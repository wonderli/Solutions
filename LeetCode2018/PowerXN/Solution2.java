import java.util.*;
public class Solution2{
    public double myPow(double x, int n){
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        double currProduct = x;
        for(long i = N; i > 0; i = i/2){
            if((i %2) == 1){
                ans = ans * currProduct;
            }
            currProduct = currProduct * currProduct;
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

import java.util.*;
public class Solution2{
	public boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1)
			return true;
        long n = (long)num;
		long guess = num;
		while (guess * guess > n) {
			guess = (guess + n / guess)/2;
		}
		return guess * guess == n ? true : false;
	}
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        System.out.println(sol.isPerfectSquare(9));
        System.out.println(sol.isPerfectSquare(8));
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

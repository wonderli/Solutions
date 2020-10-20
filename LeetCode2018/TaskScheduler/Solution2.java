import java.util.*;
public class Solution2{
    public int leastInterval(char[] tasks, int n){
        int[] frequencies = new int[26];
        for(char t : tasks){
            frequencies[t - 'A']++;
        }
        int fMax = 0;
        for(int f : frequencies){
            fMax = Math.max(fMax, f);
        }
        int nMax = 0;
        for(int f : frequencies){
            if(f == fMax) nMax++;
        }
        return Math.max(tasks.length, (fMax - 1) *  ( n + 1) + nMax);
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

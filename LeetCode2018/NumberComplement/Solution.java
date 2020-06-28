import java.util.*;
public class Solution{
    public int findComplement(int num) {
        int count = 0;
        int n = num;
        while(num != 0){
            num = num >> 1;
            count++;
        }
        int allOnes = 0;
        while(count != 0){
            allOnes = (allOnes << 1 ) | 1;
            count--;
        }
        int x = n ^ allOnes;
        return x;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.findComplement(5));
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

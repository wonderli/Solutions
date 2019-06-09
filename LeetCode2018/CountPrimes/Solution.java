import java.util.*;
public class Solution{
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrimes[i] == false){
                count++;
                for(int j = 2; i * j < n; j++){
                    notPrimes[i*j] = true;
                }
            }
        }
        return count;
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

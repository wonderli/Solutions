import java.util.*;
public class Solution2{
    public int findTargetSumWays(int[] nums, int S){
        int sum = 0;
        for(int i :nums){
            sum+=i;
        }
        if(S > sum || (S + sum) %2 == 1){
            return 0;
        }
        int target = (S+sum)/2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int n : nums){
            for(int i = target; i >= n; i--){
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
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

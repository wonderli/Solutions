import java.util.*;
public class Solution2{
    int[] days;
    int[] costs;
    int[] duration = {1, 7, 30};
    Integer[] memo;
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[366];
        return dp(0);
    }
    public int dp(int index){
        if(index >= days.length) return 0;
        if(memo[index] != null) return memo[index];
        int j = index;
        int result = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            while(j < days.length && days[j] < days[index] + duration[k]){
                j++;
            }
            result = Math.min(result, dp(j) + costs[k]);
        }
        memo[index] = result;
        return result;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int x) { val = x; next = null; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
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

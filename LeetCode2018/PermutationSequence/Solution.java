import java.util.*;
public class Solution{
    Integer K = 0;
    String res;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        boolean[] visited = new boolean[n];
        K = k;
        helper(nums, visited, n, new StringBuilder());
        return res;
    }
    public void helper(int[] nums, boolean[] visited, int n, StringBuilder curr){
        if(curr.length() == n) {
            K--;
            if(K == 0) {
                res = curr.toString();
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                curr.append(nums[i]);
                helper( nums, visited, n, curr);
                curr.setLength(curr.length() - 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int n = 3;
        //int n = 4;
        //int k = 3;
        int k = 5;
        //int k = 9;
        System.out.println(sol.getPermutation(n, k));
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

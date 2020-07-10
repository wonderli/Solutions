import java.util.*;
public class Solution{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(1, n, k, curr, res);
        return res;
    }
    public void helper(int val, int n, int k, List<Integer> curr, List<List<Integer>> res){
        if(k == 0) {
            res.add(curr);
            return;
        }
        for(int i = val; i <= n; i++){
            List<Integer> tmp = new ArrayList<>(curr);
            curr.add(i);
            helper(i+1, n, k-1, curr, res);
            curr = tmp;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.combine(4, 2));
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

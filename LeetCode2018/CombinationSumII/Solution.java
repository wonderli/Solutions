import java.util.*;
public class Solution{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, target, candidates, curr, res);
        return res;
    }
    public void helper(int index, int target, int[] candidates, List<Integer> curr, List<List<Integer>> res){
        if(target == 0){
            res.add(curr);
            return;
        }
        if(index == candidates.length || target < 0){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            List<Integer> tmp = new ArrayList<>(curr);
            curr.add(candidates[i]);
            helper(i+1, target - candidates[i], candidates, curr, res);
            curr = tmp;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(sol.combinationSum2(candidates, 8));
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

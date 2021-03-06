import java.util.*;
public class Solution3{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Set<List<Integer>> resSet = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, target, candidates, curr, resSet);
        res.addAll(resSet);
        return res;
    }
    public void helper(int index, int target, int[] candidates, List<Integer> curr, Set<List<Integer>> res){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            int n = candidates[i];
            if(n > target) break;
            curr.add(n);
            helper(i, target - n, candidates, curr, res);
            curr.remove(curr.size() - 1);
        }        
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
        int[] nums = {2, 3, 6, 7};
        //int[] nums = {2, 3, 5};
        //int[] nums = {1, 2};
        //int target = 4;
        int target = 7;
        //int target = 8;
        System.out.println(sol.combinationSum(nums, target));
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

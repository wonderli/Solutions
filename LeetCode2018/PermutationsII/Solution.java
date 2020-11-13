import java.util.*;
public class Solution{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, visited);
        return res;
    }
    public void helper(int[] nums, List<Integer> curr, List<List<Integer>> res, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        int last = -1;
        for(int i = 0; i < nums.length; i++){
            if(last > -1 && nums[i] == nums[last]) continue;
            if(!visited[i]){
                visited[i] = true;
                curr.add(nums[i]);
                helper( nums, curr, res, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
                last = i;
            }
        }
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(sol.permuteUnique(nums));
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

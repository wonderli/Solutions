import java.util.*;
public class Solution{
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, k, n, new ArrayList<>(), res);
        return res;
    }
    public void helper(int index, int k, int sum, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == k && sum == 0){
            res.add(curr);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, i, index);
            List<Integer> tmp = new ArrayList<>(curr);
            curr.add(nums[index]);
            helper(i + 1, k, sum - nums[index], curr, res);
            curr = tmp;
            swap(nums, i, index);
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        //int k = 3;
        //int n = 7;
        int k = 3;
        int n = 9;
        System.out.println(sol.combinationSum3(k, n));
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

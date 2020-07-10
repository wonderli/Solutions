import java.util.*;
public class Solution2{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, res);
        return res;
    }
    public void helper(int index, int[] nums, List<List<Integer>> res) {
        if(index == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int num : nums){
                curr.add(num);
            }
            res.add(curr);
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[index]) continue;
            swap(nums, i, index);
            helper(i + 1, nums, res);
            swap(nums, i, index);

        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
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

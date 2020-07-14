import java.util.*;
public class Solution{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++){
            helper(0, i, nums, new ArrayList<>(), res);
        }
        return res;
    }
    public void helper(int index, int num, int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(num == 0){
            res.add(curr);
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            swap(nums, i, index);
            List<Integer> tmp = new ArrayList<>(curr);
            curr.add(nums[index]);
            helper(i+1, num - 1, nums, curr, res); 
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
        int[] nums = {1, 2, 2};
        System.out.println(sol.subsetsWithDup(nums));
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

import java.util.*;
public class Solution{
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(0, nums, result, curr);
        return result;
    }
    public void helper(int index, int[] nums, List<List<Integer>> result, List<Integer> curr){
        if(curr.size() == nums.length){
            result.add(curr);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, index, i);
            int first = nums[index];
			List<Integer> tmp = new ArrayList<>(curr);
            curr.add(first);
            helper(index+1, nums, result, new ArrayList<>(curr));
            curr = tmp;
            swap(nums, index, i);
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
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

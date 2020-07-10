import java.util.*;
import java.util.stream.Collectors;
public class Solution2{
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);
		helper(0, nums, new ArrayList<>(), res);
		return res.stream().collect(Collectors.toList());
	}

	public void helper(int index, int[] nums, List<Integer> curr, Set<List<Integer>> res) {
		if (index == nums.length) {
			res.add(curr);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[index])
				continue;
			List<Integer> tmp = new ArrayList<>(curr);
			curr.add(nums[i]);
			swap(nums, i, index);
			helper(index + 1, nums, curr, res);
			swap(nums, i, index);
			curr = tmp;

		}
	}

	public void swap(int[] nums, int i, int j) {
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

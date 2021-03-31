import java.util.*;
public class Solution{
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null) return null;
		int len = candidates.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		ArrayList<Integer> curr = new ArrayList<Integer>();
		helper(0, candidates, target, curr, res);
		return res;
	}
	public void helper(int index, int nums[], int target, ArrayList<Integer> curr, List<List<Integer>> res){
		if(target == 0){
			res.add(curr);
			return;
		}
		for(int i = index; i<nums.length; i++){
			if(target < nums[i]) break;
			if(i > index && nums[i] == nums[i-1]) continue;
			ArrayList<Integer> t = new ArrayList<Integer>(curr);
			curr.add(nums[i]);
			helper(i + 1, nums, target - nums[i], curr, res);
			curr = t;
		}
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		int nums[] = {10, 1, 2, 7, 6, 1, 5};
		List<List<Integer>> res = sol.combinationSum2(nums, 8);
		for(List e : res){
			System.out.println(e);
		}

	}
}

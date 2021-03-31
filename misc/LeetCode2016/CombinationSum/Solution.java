import java.util.*;
public class Solution{
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null) return null;
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(0, candidates, target, curr, set);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(List e : set){
			res.add(e);

		}
		return res;
	}
	public void helper(int index, int nums[], int target, ArrayList<Integer> curr, HashSet<List<Integer>> set){
		if(target == 0){
			set.add(curr);
			return;
		}
		for(int i = index; i < nums.length; i++){
			if(nums[i] > target) break;
			if(i > index && nums[i] == nums[i-1]) continue;
			ArrayList<Integer> t = new ArrayList<Integer>(curr);
			curr.add(nums[i]);
			helper(i, nums, target - nums[i], curr, set);
			curr = t;

		}

	}

	public static void main(String args[]){
		Solution sol = new Solution();
		int nums[] = {2,3,6,7};
		List<List<Integer>> res = sol.combinationSum(nums, 7);
		for(List e : res){
			System.out.println(e);
		}
	}
}

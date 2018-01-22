import java.util.*;
class Pair implements Comparable<Pair>{
	int val;
	int ind;
	Pair(int val, int ind){
		this.val = val;
		this.ind = ind;
	}
	public int compareTo(Pair b){
		return this.val - b.val;
	}

}
public class Solution{
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length == 0) return new int[]{};
		int first = 0;
		int second = 0;
		int len = nums.length;
		Pair l[] = new Pair[len];
		for(int i = 0; i < len; i++){
			l[i] = new Pair(nums[i], i);
		}
		Arrays.sort(l);
		int result[] = new int[2];
		int i = 0;
		int j = len - 1;
		while(i < j){
			if(l[i].val + l[j].val == target) {
				result[0] = l[i].ind;
				result[1] = l[j].ind;
				break;
			}else if(l[i].val + l[j].val < target){
				i++;
			}else {
				j--;
			}
		}
		return result;
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		int nums[] = {150, 24, 79, 50, 88, 345, 3};
		System.out.println(Arrays.toString(sol.twoSum(nums, 200)));
	}
}

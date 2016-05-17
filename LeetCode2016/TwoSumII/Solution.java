import java.util.*;
public class Solution{
	public int[] twoSum(int[] numbers, int target) {
		if(numbers == null) return null;
		int len = numbers.length;
		int i = 0;
		int j = len - 1;
		int res[] = new int[2];
		while(i < j){
			if(numbers[i] + numbers[j] == target){
				res[0] = i+1;
				res[1] = j+1;
				break;
			}else if(numbers[i] + numbers[j] < target){
				i++;
			}else{
				j--;
			}
		}
		return res;
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		int nums[] = {2, 7, 11, 15};
		System.out.println(Arrays.toString(sol.twoSum(nums, 9)));

	}
}

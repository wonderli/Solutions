import java.util.*;
public class Solution{
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int len = nums.length;
		int i = 0;
		int j = 0;
		boolean flag = false;
		while(i < len){
			if(nums[i] == 0 && flag == false){
				j = i;
				flag = true;
				i++;
			//}else if(nums[i] == 0 && flag == true){
				//i++;
			}else if(nums[i] != 0 && nums[j] == 0){
				swap(nums, i, j);
				i = j + 1;
				flag = false;
			}else{
				i++;
			}
		}

	}
	public void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		int nums[] = {0, 1, 0, 3, 12};
		sol.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{0, 1, 0, 0, 0, 5, 0, 0, 13};
		sol.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{2,1};
		sol.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}

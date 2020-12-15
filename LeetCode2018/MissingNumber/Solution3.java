import java.util.*;
public class Solution3{	
	public int missingNumber(int[] nums) {
		int n = nums.length;
		int result = n;
		for(int i = 0; i < n; i++){
			result ^= nums[i];
			result ^= i;
		}
		return result;
	}
	
	public static void main(String args[]){
		Solution3 sol = new Solution3();
	}
}


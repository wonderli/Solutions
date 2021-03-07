import java.util.*;
class Solution{
	public int countElements(int[] arr) {
		if (arr == null || arr.length <= 1)
			return 0;
		Arrays.sort(arr);
		int count = 0;
		int runLength =1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i - 1] != arr[i]) {
				if(arr[i - 1] +1 == arr[i]) {
					count += runLength;
				}
				runLength = 0;
			}
			runLength++;
		}
		return count;
	}
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

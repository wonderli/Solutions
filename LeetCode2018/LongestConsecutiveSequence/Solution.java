import java.util.*;
public class Solution{
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int curr = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1] + 1){
                    curr++;
                }else{
                    res = Math.max(res, curr);
                    curr = 1;
                }
            }
        }
        return Math.max(curr, res);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

import java.util.*;
class Solution{
    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int max = 0;
        for(int i = 0; i <nums.length; i++){
            sum += nums[i];
            if(sumToIndex.containsKey(sum)){
                max = Math.max(max, i - sumToIndex.get(sum));
            }else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

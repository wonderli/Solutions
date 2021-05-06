import java.util.*;
class Solution{
    public int jump(int[] nums) {
        int n = nums.length;
        int count = 0;
        int currentEnd = 0;
        int farthest = 0;
        for(int i = 0; i < n-1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(i == currentEnd){
                count++;
                currentEnd = farthest;
            }
        }
        return count;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

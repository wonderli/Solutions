import java.util.*;
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int[] up = new int[n];
        int[] down = new int[n];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    up[i] = Math.max(up[i], down[j] + 1);
                }else if(nums[i] < nums[j]){
                    down[i] = Math.max(down[i], up[j]+1);
                }
            }
        }
        return 1 + Math.max(down[n-1], up[n-1]);
    }
}
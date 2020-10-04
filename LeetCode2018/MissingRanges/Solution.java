import java.util.*;
public class Solution{
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            String r = helper(lower, upper);
            res.add(r);
            return res;
        }
        if(lower < nums[0]){
            res.add(helper(lower,nums[0] - 1));
        }
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] > 1){
                res.add(helper(nums[i-1] + 1, nums[i] - 1));
            }
        }
        if(nums[nums.length - 1] < upper){
            res.add(helper(nums[nums.length -1] + 1, upper));
        }
        return res;
    }
    public String helper(int lower, int upper){
        if(lower == upper){
            return String.valueOf(lower);
        }else{
            return String.format("%d->%d", lower, upper);
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int[] a = {0,1,3,50,75};
        System.out.println(sol.findMissingRanges(a, 0, 99));
    }
}

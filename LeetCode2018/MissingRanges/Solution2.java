import java.util.*;
public class Solution2{

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) {
            result.add(getRange(lower, upper));
            return result;
        }
        int start = lower;
        int end = upper;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num == start){
                start++;
            }else if(num > start){
                end = num - 1;
                result.add(getRange(start, end));
                start = num+1;
            }
        }
        if(upper > nums[n-1]){
            result.add(getRange(start, upper));                
        }
        return result;
    }
    private String getRange(int lower, int upper){
        if(lower == upper){
            return Integer.toString(lower);
        }
        return String.format("%d->%d", lower, upper);
    }


    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

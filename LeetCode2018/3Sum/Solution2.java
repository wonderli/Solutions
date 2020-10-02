import java.util.*;
public class Solution2{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ret= new ArrayList<>();
        for(int i = 0; i < len - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < len - 1; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = len - 1;
                int sum = nums[i] + nums[j];
                while(l <= r){
                    int mid = l + (r - l)/2;
                    if(nums[mid] == -1 * sum){
                        ret.add(Arrays.asList(nums[i], nums[j], nums[mid]));
                    }else if(nums[mid] > -1 * sum){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
            }
        }
        return ret;
        }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

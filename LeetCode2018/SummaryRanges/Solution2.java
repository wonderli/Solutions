import java.util.*;
public class Solution2{
    public List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<>();
        for(int i = 0, j = 0; j < nums.length; j++){
            if(j + 1 < nums.length && nums[j+1] == nums[j] + 1){
                continue;
            }
            if(i == j){
                res.add(nums[i] +"");
            }else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

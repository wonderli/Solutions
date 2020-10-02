import java.util.*;
public class Solution3{
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < num.length - 2; i++){
            if(i > 0 && num[i] == num[i-1]) continue;
            int l = i + 1;
            int r = num.length - 1;
            int sum = 0 - num[i];
            while(l < r){
                if(num[l] + num[r] == sum){
                    ret.add(Arrays.asList(num[i], num[l], num[r]));
                    while(l < r && num[l] == num[l+1]) l++;
                    while(l < r && num[r] == num[r - 1]) r--;
                    l++;
                    r--;
                }else if(num[l] + num[r] < sum){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ret;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}

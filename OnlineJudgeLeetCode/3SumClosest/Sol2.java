//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
import java.util.*;
public class Sol2{
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int k = num.length-1;
        int difference = Integer.MAX_VALUE;
        int min = 0;
        int i = 0;
        int j = 0;
        for(i = 0; i < num.length - 2; i++){
            for(j = i + 1, k = num.length - 1; j < k;){
                int curr = num[i] + num[j] + num[k];
                if(curr < target){
                    int tmp = target - curr;
                    if(tmp < difference){
                        difference = tmp;
                        min = curr;
                    }
                    j++;
                }else if(curr > target){
                    int tmp = curr - target;
                    if(tmp < difference){
                        difference = tmp;
                        min = curr;
                    }
                    k--;
                }else{
                    return curr;
                }
            }
        }
        return min;
    }
    public static void main(String args[]){
        int num[] = {-3, 0,1,2};
        Sol2 s = new Sol2();
        System.out.println(s.threeSumClosest(num, 1));

    }
}

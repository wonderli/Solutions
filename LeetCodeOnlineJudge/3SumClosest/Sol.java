//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
import java.util.*;
public class Sol{
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int currmin = num[0] + num[1] + num[2];
        int min = currmin;
        int curr = 0;
        for(int i = 0; i < num.length - 2; i++){
            for(int j = i + 1; j < num.length - 1; j++){
                int k = j + 1;
                while( k < num.length){
                    curr = num[i] + num[j] + num[k];
                    //System.out.println(curr);
                    if(Math.abs(target - curr) < Math.abs(target - currmin)){
                        currmin = curr;
                    }
                    k++;
                }
                if(Math.abs(target - currmin) < Math.abs(target - min)){
                    min = currmin;
                }
            }
        }
        return min;
    }
    public static void main(String args[]){
        int num[] = {-3, 0,1,2};
        Sol s = new Sol();
        System.out.println(s.threeSumClosest(num, 1));

    }
}

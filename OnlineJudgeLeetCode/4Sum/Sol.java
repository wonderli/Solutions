//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
import java.util.*;
public class Sol{
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        for(i = 0; i < num.length - 3; i++){
            for(j = i + 1; j < num.length - 2; j++){
                for(k = j + 1, l = num.length - 1; k < l;){
                    int curr = num[i] + num[j] + num[k] + num[l];
                    if(curr > target){
                        l--;
                    }else if(curr < target){
                        k++;
                    }else{
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[l]);
                        ret.add(tmp);
                        k++;
                        l--;
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(ret);

    }
    public static void main(String args[]){
        int num[] = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        Sol s = new Sol();
        ArrayList<ArrayList<Integer>> ret = s.fourSum(num, target);
        for(ArrayList<Integer> e : ret){
            System.out.println(e.toString());
        }

    }
}

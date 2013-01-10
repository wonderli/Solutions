//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
import java.util.*;
public class Sol{
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 2; i++){
            for(int j = i + 1; j < num.length - 1; j++){
                int k = j + 1;
                while(k < num.length){
                    if(num[k] == (-1)*(num[i] + num[j])){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        ret.add(tmp);
                        break;
                    }else if(num[k] < (-1)*(num[i] + num[j])){
                        k++;
                    }else{
                        break;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> newret = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> e : ret){
            newret.add(e);
        }
        return newret;

    }
    public static void main(String args[]){
        int num[] = {0,0,0,0};
        Sol s = new Sol();
        ArrayList<ArrayList<Integer>> ret = s.threeSum(num);
        for(ArrayList<Integer> e : ret){
            System.out.println(e.toString());
        }

    }
}

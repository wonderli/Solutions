//Given an array of integers, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
import java.util.*;
public class Solution{
    private class Pair implements Comparable<Pair>{
        int first;
        int second;
        Pair(int a, int b){
            first = a;
            second = b;
        }
        public int compareTo(Pair a){
            return this.second - a.second;
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length < 1) return new int[2];
        int len = numbers.length;
        Pair[] p = new Pair[len];
        for(int i = 0; i < len; i++){
            p[i] = new Pair(i, numbers[i]);
        }
        Arrays.sort(p);
        int i = 0;
        int j = len - 1;
        int ret[] = new int[2];
        while(i < j){
            if(p[i].second + p[j].second == target){
                ret[0] = p[i].first + 1;
                ret[1] = p[j].first + 1;
                break;
            }else if(p[i].second + p[j].second < target){
                i++;
            }else{
                j--;
            }
        }
        if(ret[0] > ret[1]){
            int tmp = ret[0];
            ret[0] = ret[1];
            ret[1] = tmp;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[] = {5, 75, 25};
        int target = 100;
        int B[] = sol.twoSum(A, target);
        System.out.println(Arrays.toString(B));
    }
}

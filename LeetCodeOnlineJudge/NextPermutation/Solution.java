// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place, do not allocate extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
import java.util.*;
public class Solution{
    public void nextPermutation(int[] num) {
        int len = num.length;
        int i = len - 2;
        //from right to left, find first i < i+1 number
        while(i >= 0 && num[i] >= num[i+1]){
            i--;
        }
        //if i < 0, means all permutation finished
        if(i < 0) {
            Arrays.sort(num);
            return;
        }
        //from i + 1, from right to left, find the first num[j] > num[k]
        int j = len - 1;
        while(num[j] <= num[i]){
            j--;
        }
        //swap them 
        int tmp = num[j];
        num[j] =  num[i];
        num[i] = tmp;
        //reverse from i+1 till end
        int low = i + 1;
        int high = len - 1;
        while(low < high){
            tmp = num[low];
            num[low] = num[high];
            num[high] = tmp;
            low++;
            high--;
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int num[] = {1, 5, 1};
        sol.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
}

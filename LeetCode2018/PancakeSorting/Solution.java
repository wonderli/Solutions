import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        if(isIncreasing(arr)){
            return new ArrayList<>();
        }
        int last = n-1;
        List<Integer> result = new ArrayList<>();
        while(!isIncreasing(arr)){
            int index = findLargest(arr, last);
            flip(arr, index);
            result.add(index+1);
            flip(arr, last);
            result.add(last+1);
            last--;
        }
        return result;
    }
    private void flip(int[] arr, int index){
        int i = 0;
        int j = index;
        while(i < j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
    private int findLargest(int[] arr, int last){
        int max = arr[last];
        int result = last;
        for(int i = last - 1; i >= 0; i--){
            if(arr[i] > max){
                max = arr[i];
                result = i;
            }
        }
        return result;
    }
    private boolean isIncreasing(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]) return false;
        }
        return true;
    }
     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] a = {3, 2, 4, 1};
         sol.pancakeSort(a);
      }
}
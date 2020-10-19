import java.util.*;
public class Solution2{
    public int findCelebrity(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n - 1; i++){
            for(int j = i+1; j < n; j++){
                if(knows(i, j)){
                    arr[j]++;
                    arr[i]--;
                }
                if(knows(j, i)){
                    arr[i]++;
                    arr[j]--;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n-1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

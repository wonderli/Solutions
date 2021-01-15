import java.util.*;
public class Solution2{
    public int kthSmallest(int[][] matrix, int k){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while(low < high){
            int mid = low + (high - low)/2;
            int count = 0;
            int j = n -1;
            for(int i = 0;i<m; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j + 1;
            }
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

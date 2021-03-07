import java.util.*;
public class Solution{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            int l = 0;
            int r = col - 1;
            while(l <= r){
                int mid = l + (r - l)/2;
                if(matrix[i][mid] > target){
                    r = mid - 1;
                }else if(matrix[i][mid] < target){
                    l = mid + 1;
                }else {
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

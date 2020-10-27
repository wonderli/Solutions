import java.util.*;
public class Solution{
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[102][102];
        arr[0][0] = (double) poured;
        for(int r= 0; r <= query_row; r++){
            for(int c = 0; c <= r; c++){
                double q= (arr[r][c] - 1.0)/2.0;
                if(q > 0){
                    arr[r+1][c] += q;
                    arr[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1, arr[query_row][query_glass]);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

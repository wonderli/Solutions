import java.util.*;
public class Solution2{
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
            int last = n - 1 - layer;
            for(int i = layer; i < last; i++){
                int tmp = matrix[layer][i];
                matrix[layer][i] = matrix[n-i-1][layer];
                matrix[n-i-1][layer] = matrix[n-1-layer][n-1-i];
                matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];
                matrix[i][n-1-layer] = tmp;
            }
        }
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

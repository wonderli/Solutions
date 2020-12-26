import java.util.*;
public class Solution3{
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n/2; i++){
			for(int diff =0; diff < n - 1 - 2*i; diff++){
				int tmp = matrix[i][i+diff];
				matrix[i][i+diff] = matrix[n-1-i - diff][i];
				matrix[n-1-i-diff][i] = matrix[n-1-i][n-1-i-diff];
				matrix[n-1-i][n-1-i-diff] = matrix[i+diff][n-1-i];
				matrix[i+diff][n-1-i] = tmp;
			}
		}
	}
}

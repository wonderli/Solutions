import java.util.ArrayList;
import java.util.List;

class Solution3 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0)
			return res;
		int row = matrix.length;
		int col = matrix[0].length;
        int upper = 0;
        int lower = row - 1;
        int left = 0;
        int right = col - 1;
        while(upper <= lower && left <= right){
            for(int j = left; j <= right; j++){
                res.add(matrix[upper][j]);
            }
            upper++;
            for(int i = upper; i <= lower; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(upper <= lower){
                for(int j = right; j >= left; j--){
                    res.add(matrix[lower][j]);
                }
                lower--;
            }

            if(left <= right){
                for(int i = lower; i>= upper; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
		return res;

	}

}

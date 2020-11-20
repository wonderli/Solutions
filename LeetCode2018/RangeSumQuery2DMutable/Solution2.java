import java.util.*;

public class Solution2 {
    public static void main(String args[]) {
        Solution2 sol = new Solution2();
    }
}

class NumMatrix {
    int[][] matrix;
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int h = matrix.length;
        if (h > 0) {


            this.sumMatrix = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j == 0) {
                        sumMatrix[i][j] = matrix[i][j];
                    } else {
                        sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
                    }

                }
            }
        }
        //this.map = new HashMap<>();
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;

        for (int j = col; j < matrix[row].length; j++) {
            sumMatrix[row][j] = sumMatrix[row][j] + diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sumMatrix[i][col2] - (col1 > 0 ? sumMatrix[i][col1 - 1] : 0);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val); int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

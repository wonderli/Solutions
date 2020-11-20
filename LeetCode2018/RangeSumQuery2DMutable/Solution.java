import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class NumMatrix {
    private class Rectangle{
        int row1;
        int row2;
        int col1;
        int col2;
        public Rectangle(int r1, int c1, int r2, int c2){
            row1 = r1;
            row2 = r2;
            col1 = c1;
            col2 = c2;
        }
        public boolean contains(int row, int col){
            return row1 <= row && row <= row2 && col1 <= col && col <= col2;
        }
    }
    Map<Rectangle, Integer> map;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.map = new HashMap<>();
    }
    
    public void update(int row, int col, int val) {
        int origin = matrix[row][col];
        matrix[row][col] = val;
        for(Rectangle rectangle : map.keySet()){
            if(rectangle.contains(row, col)){
                int sum = map.get(rectangle);
                sum = sum - origin + val;
                map.put(rectangle, sum);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        Rectangle rectangle = new Rectangle(row1, col1, row2, col2);
        int sum = 0;
        for(int i = row1; i <= row2;i++){
            for(int j = col1; j<= col2; j++){
                sum += matrix[i][j];
            }
        }
        map.put(rectangle, sum);
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

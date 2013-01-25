//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//    Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//
public class Solution2{
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(x < m && y >= 0){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] < target) x++; 
            else y--;

        }
        return false;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

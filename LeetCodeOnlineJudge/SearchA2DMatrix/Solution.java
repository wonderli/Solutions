//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//    Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//
public class Solution{
//  Large Set can't pass......
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix.length == 0 || matrix[0].length == 0)return false;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        return search(matrix, 0, n - 1, target);
//    }
//    public boolean search(int[][] matrix, int i, int j, int target){
//        if(i >= matrix.length || j < 0) return false;
//        if(matrix[i][j] == target) return true;
//        else if(matrix[i][j] < target) return search(matrix, i + 1, j, target);
//        else return search (matrix, i, j - 1, target);
//    }
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l < r){
            int mid = (l + r)/2;
            int x = mid/n;
            int y = mid%n;
            if(matrix[x][y] < target){
                l = mid + 1;
            }else r = mid;
        }
        int x = l/n;
        int y = l%n;
        return matrix[x][y] == target;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

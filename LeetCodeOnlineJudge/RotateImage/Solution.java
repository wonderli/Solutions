//You are given an n x n 2D matrix representing an image.
//
//Rotate the image by 90 degrees (clockwise).
public class Solution{
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l = 0;
        while(l < n/2){
            int first = l;
            int last = n - 1 - l;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
            l++;
        }
    }
    public static void printM(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
            System.out.println();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int A[][] = {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                    };
        printM(A);
        sol.rotate(A);
        printM(A);

    }
}

//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
public class Solution{
// only work in n is even.....
//    public int[][] generateMatrix(int n) {
//        if(n == 0) return new int[0][0];
//        int A[][] = new int[n][n];
//        int level = 0; 
//        int count = 1;
//        while(level <= n/2){
//            for(int j = level; j < n - 1 - level; j++){
//                A[level][j] = count;
//                count++;
//            }
//            for(int i = level; i < n - 1 - level; i++){
//                A[i][n - 1 - level] = count;
//                count++;
//            }
//            for(int j = n - 1 - level; j > level; j--){
//                A[n - level - 1][j] = count;
//                count++;
//            }
//            for(int i = n - level - 1; i > level; i--){
//                A[i][level] = count;
//                count++;
//            }
//            level++;
//        }
//        return A;
//    }
    public int[][] generateMatrix(int n){
        if(n == 0) return new int[0][0];
        int A[][] = new int[n][n];
        int count = 1;
        fill(A, 0, 0, n, n, count);
        return A;
    }
    public void fill(int A[][], int x, int y, int r, int c, int count){
        if(r <= 0 || c <= 0) return ;
        for(int j = y; j < y + c - 1; j++){
            A[x][j] = count;
            count++;
        }
        for(int i = x; i < x + r - 1; i++){
            A[i][y + c - 1] = count;
            count++;
        }
        for(int j = y + c - 1; j >= y; j--){
            A[x + r - 1][j] = count;
            count++;
        }
        for(int i = x + r - 2; i > x; i--){
            A[i][y] = count;
            count++;
        }
        fill(A, x + 1, y + 1, r - 2, c - 2, count);
    }
    public static void printMatrix(int A[][]){
        int m = A.length;
        int n = A[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        int n = 4;
        int A[][] = sol.generateMatrix(n);
        printMatrix(A);
    }
}

public class Q62{
    public static void printMatrix(int matrix[][], int M, int N){
        int level = 0;
        //int max = (M > N) ? M:N;
        int min = (M < N) ? M:N;
        System.out.println();
        //while(level < max/2){
        while(level <= min/2){
            for(int j = level; j < N - level - 1; j++){
                System.out.print(matrix[level][j] + "\t");
            }
            for(int i = level; i < M - level - 1; i++) {
                System.out.print(matrix[i][N - level - 1] + "\t");
            }
            for(int j = N - level - 1; j > level; j--){
                System.out.print(matrix[M - level - 1][j] + "\t");
            }
            for(int i = M - level - 1; i > level; i-- ){
                System.out.print(matrix[i][level] + "\t");
            }
            level++;
        }
    }
    public static void printMatrix(int matrix[][], int m, int n, int k){
        if(m <= 0 || n <= 0)
            return;
        if(m == 1){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[k][k + j] + "\t");
            }
            return;
        }
        if(n == 1) {
            for(int i = 0; i < m; i++){
                System.out.print(matrix[k + i][k] + "\t");
            }
            return;
        }
        for(int j = 0; j < n - 1; j++){
            System.out.print(matrix[k][k + j] + "\t");
        }
        for(int i = 0; i < m - 1; i++){
            System.out.print(matrix[k + i][k + n - 1] + "\t");
        }
        for(int j = 0; j < n - 1; j++){
            System.out.print(matrix[k + m - 1][k + n - 1 - j] + "\t");
        }
        for(int i = 0; i < m - 1; i++){
            System.out.print(matrix[k + m - 1 - i][k] + "\t");
        }
        printMatrix(matrix, m - 2, n - 2, k + 1);
    }
    public static void main(String args[]){
        int M = 5;
        int N = 6;
        int matrix[][] = new int[M][N];
        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = count;
                System.out.print(matrix[i][j] + "\t");
                count++;
            }
            System.out.print("\n");
        }
        printMatrix(matrix, M, N);
        System.out.println();
        printMatrix(matrix, M, N, 0);
    }
}

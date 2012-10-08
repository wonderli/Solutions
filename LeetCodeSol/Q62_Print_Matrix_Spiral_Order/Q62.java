public class Q62{
    public static void printMatrix(int matrix[][], int M, int N){
        int level = 0;
        System.out.println();
        while(level <= M/2){
            for(int j = level; j < N - level; j++){
                System.out.print(matrix[level][j] + "\t");
            }
            for(int i = level + 1; i < M - level; i++) {
                System.out.print(matrix[i][N - level - 1] + "\t");
            }
            for(int j = N - level - 2; j >= level; j--){
                System.out.print(matrix[M - level - 1][j] + "\t");
            }
            for(int i = M - level - 2; i >= level + 1; i-- ){
                System.out.print(matrix[i][level] + "\t");
            }
            level++;
        }
    }
    public static void main(String args[]){
        int M = 4;
        int N = 4;
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
    }
}

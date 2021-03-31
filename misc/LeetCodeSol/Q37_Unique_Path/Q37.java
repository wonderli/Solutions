public class Q37{
    public static int travel(int row, int col, int M, int N){
        if(row == M && col == N){
            return 1;
        }
        if(row > M || col > N){
            return 0;
        }
        return travel(row+1, col, M, N) + travel(row, col+1, M, N);
    }
    public static int f(int x, int y){
        if(x == 1 && y == 0) return 1;
        if(x == 0 && y == 1) return 1;
        if(x == 0 && y == 0) return 0;
        if(x < 0 || y < 0) return 0;
        return f(x - 1, y) + f(x, y - 1);
    }
    public static int f_dp(int x, int y, int M, int N, int matrix[][]){
        if(x == M && y == N){
            return 1;
        }
        if(x > M || y > N){
            return 0;
        }
        if(matrix[x + 1][y] == -1) matrix[x + 1][y] = f_dp(x + 1, y, M, N, matrix);
        if(matrix[x][y + 1] == -1) matrix[x][y + 1] = f_dp(x, y + 1, M, N, matrix);
        return matrix[x + 1][y] + matrix[x][y + 1];
    }

    public static void main(String args[]){
        int M = 10;
        int N = 10;

        int x = travel(0, 0, M, N);
        System.out.println(x);
        int z = f(M,N);
        System.out.println(z);
        int size = 100;
        int matrix[][] = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                matrix[i][j] = -1;
            }
        }
        int o = f_dp(0, 0, M, N, matrix);
        System.out.println(o);
    }
}

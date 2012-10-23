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

    public static void main(String args[]){

        int x = travel(0, 0, 10, 10);
        System.out.println(x);
        int z = f(10,10);
        System.out.println(z);
    }
}

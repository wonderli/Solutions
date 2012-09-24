//Chapter 9 Question 2
public class Q2{
    public static int path(int matrix[][], int x, int y){
        if(x == 0) return matrix[0][y];
        if(y == 0) return matrix[x][0];
        if(matrix[x][y] != -1) return matrix[x][y];
        else {
            matrix[x][y] = path(matrix, x - 1, y) +  path(matrix, x, y - 1);
            return matrix[x][y];
        }
    }
    public static int pathMath(int x, int y) {
        return factorial(x + y) / (factorial(x) * factorial(y));
    }
    public static int factorial(int x) {
        if(x == 0 || x == 1) return 1;
        return x * factorial(x - 1);
    }
    public static void main(String args[]) {
        int size = 1000;
        int matrix[][] = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                matrix[i][j] = -1;
            }
        }
        for(int j = 0; j < size; j++) {
            matrix[0][j] = 1;
        }
        for(int i = 0; i < size; i++) {
            matrix[i][0] = 1;
        }
        int len = 5;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.println("--------------------------------------");
                System.out.println("Path(" + i + "," + j + "): \t" + path(matrix, i, j));
                System.out.println("Path(" + i + "," + j + "): \t" + pathMath(i, j) + " (Math method)");
                System.out.println("--------------------------------------");
                System.out.println();
            }
        }

    }
}

public class Q42{
    int x;
    int y;
    public boolean stepWise(int matrix[][], int row, int col, int key, Q42 r){
        if(row > matrix.length-1 || col < 0) return false;
        if(matrix[row][col] == key){
            r.x = row;
            r.y = col;
            return true;
        }
        if(matrix[row][col] < key){
           row++;
           return stepWise(matrix, row, col, key, r);
        }else if(matrix[row][col] > key){
            col--;
            return stepWise(matrix, row, col, key, r);
        }
        return false;
    }
    public static void main(String args[]){
        int matrix[][] = {
            {1, 4, 7, 11, 16},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        Q42 r = new Q42();
        int key = 50;
        int M = 5;
        int N = 5;
        boolean ret = r.stepWise(matrix, 0, N - 1, key, r);
        System.out.println(ret);
        System.out.println("ROW: " + r.x + " COL: " + r.y);
    }
}

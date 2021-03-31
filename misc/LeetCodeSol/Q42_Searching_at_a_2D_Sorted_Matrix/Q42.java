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
    public int binSearch(int matrix[][], int left, int right, int row, int key){
        if(left > right) return -1;
        int mid = left + (right - left)/2;
        if(matrix[row][mid] == key){
            return mid;
        }
        if(matrix[row][mid] < key ){
            left = mid + 1;
            return binSearch(matrix, left, right, row, key);
        }else if(matrix[row][mid] > key){
            right = mid - 1;
            return binSearch(matrix, left, right, row, key);
        }
        return -1;
    }
    public boolean binPartSearch(int matrix[][], int row_up, int row_down, int col_left, int col_right, int key, Q42 r){
        if(row_up > row_down || col_left > col_right) return false;
        if(key < matrix[row_up][col_left] || key > matrix[row_down][col_right]) return false;
        int mid_row = (row_up + row_down)/2;
        int mid_col = binSearch(matrix, col_left, col_right, mid_row, key);
        if(mid_col>= col_left && mid_col <= col_right && matrix[mid_row][mid_col] == key){
            r.x = mid_row;
            r.y = mid_col;
            return true;
        }
        return binPartSearch(matrix, mid_row + 1, row_down, col_left, mid_col - 1, key, r) || binPartSearch(matrix, row_up, mid_row - 1, mid_col, col_right, key, r);
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
        int key = 3;
        int M = 5;
        int N = 5;
        boolean ret = r.stepWise(matrix, 0, N - 1, key, r);
        System.out.println(ret);
        System.out.println("ROW: " + r.x + " COL: " + r.y);
        Q42 r2 = new Q42();
        boolean x = r2.binPartSearch(matrix, 0, M - 1, 0, N - 1, key, r2);
        System.out.println("ROW: " + r2.x + " COL: " + r2.y);
        
    }
}

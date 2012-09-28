import java.util.*;
public class Q9{
    public static final int N = 8;
    public static void Q(int row, int[] Columns, ArrayList<Integer[]> result) {
        if(row == N){
            Integer[] c = new Integer[Columns.length];
            for(int i = 0; i < Columns.length; i++) {
                c[i] = new Integer(Columns[i]);
            }
            result.add(c);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(check(row, Columns, i)) {
                Columns[row] = i;
                Q(row + 1, Columns, result);
                Columns[row] = -1;
            }
        }
    }
    public static boolean check(int row, int[] Columns, int column) {
        for(int row2 = 0; row2 < row; row2++){
            int column2 = Columns[row2];
            int row_dist = 0;
            int column_dist = 0;
            if(column == column2)
                return false;
            row_dist = Math.abs(row - row2);
            column_dist = Math.abs(column - column2);
            if(row_dist == column_dist)
                return false;
        }
        return true;
    }
    public static int[] getArray(Integer[] array) {
        int[] intArray = new int[array.length];
        for(int i = 0; i < intArray.length; i++) {
            intArray[i] = array[i].intValue();
        }
        return intArray;
    }
    public static void main(String args[]) {
        int row = 0;
        int[] Columns = new int[N];
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        for(int i = 0; i < N; i++) {
            Columns[i] = -1;
        }
        Q(row, Columns, result);
        int count = 0;
        for(int i = 0; i < result.size(); i++){
            count++;
            System.out.println(Arrays.toString(getArray(result.get(i))));
        }
        System.out.println(count);
    }
}

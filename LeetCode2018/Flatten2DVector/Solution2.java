import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}


class Vector2D {
    int[][] arr;
    int i = 0;
    int j = 0;
    public Vector2D(int[][] v) {
        arr = v;
    }

    public int next() {
        int res = 0;
        if(j < arr[i].length){
            res = arr[i][j];
        }else{
            j = 0;
            i = getNext(i);
            res = arr[i][j];
        }
        update();
        return res;
    }
    public void update(){
        if(j +1 < arr[i].length){
            j++;
        }else{
            i = getNext(i);
            j = 0;
        }
    }
    public int getNext(int row){
        row++;
        while(row < arr.length){
            if(arr[row].length > 0){
                return row;
            }
            row++;
        }
        return row;
    }

    public boolean hasNext() {
        if(arr == null || arr.length == 0) return false;
        if(i >= arr.length) return false;
        if(j < arr[i].length) return true;
        int r = getNext(i);
        return r < arr.length;
    }

}

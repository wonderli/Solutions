import java.util.*;
class Solution {
    int m;
    int n;
    public int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        for(int i = 0; i < m; i++){
            sort(mat, i, 0);
        }
        
        for(int j = 1; j < n; j++){
            sort(mat, 0, j);
        }
        return mat;
    }
    
    private void sort(int[][] mat, int i, int j){
        List<Integer> list = new ArrayList<>();
        int a= i;
        int b = j;
        while(i < m && j < n){
            list.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(list);
        int p = 0;
        while(a < m && b < n){
            mat[a][b] = list.get(p);
            a++;
            b++;
            p++;
        }
    }
}

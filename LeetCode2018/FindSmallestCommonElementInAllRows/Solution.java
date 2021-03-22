import java.util.*;
class Solution {
    
    public int smallestCommonElement(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] index = new int[m];
        Arrays.fill(index, 0);
        int common = Integer.MIN_VALUE;
        int i = 0;
        while(i < m && index[i] < n){
            if(mat[i][index[i]] < common){
                index[i]++;
            }else if(mat[i][index[i]] > common){
                common = mat[i][index[i]];
                i = 0;
            }else{
                i++;
            }
        }
        return i == m ? common : -1;
    }
}

import java.util.*;
class Solution {
    private class Count{
        int index;
        int nums;
        public Count(int index, int nums){
            this.index = index;
            this.nums = nums;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        Count[] count = new Count[m];
        for(int i = 0; i < m; i++){
            count[i] = new Count(i, 0);
            count[i].nums = get(mat, i);
        }
        Arrays.sort(count, (a, b)->(a.nums == b.nums ? a.index - b.index : a.nums - b.nums));
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = count[i].index;
        }
        return result;
    }
    
    private int get(int[][] mat, int i){
        
        int[] row = mat[i];
    
        
        //System.out.println(Arrays.toString(row));
        int l = 0;
        int r = row.length;
        while(l < r){
            int mid = l + (r -l)/2;
            if(row[mid] == 1){
                l = mid +1;
            }else{
                r = mid;
            }
        }
        
        return l;
    }
}

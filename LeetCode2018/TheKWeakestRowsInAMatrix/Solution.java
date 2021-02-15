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
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    count[i].nums++;    
                }else{
                    break;
                }
            }
        }
        //selectK(count, k);
        Arrays.sort(count, (a, b)->(a.nums == b.nums ? a.index - b.index : a.nums - b.nums));
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = count[i].index;
        }
        return result;
    }
    // private void selectK(Count[] count, int k){
    //     int l = 0;
    //     int r = count.length - 1;
    //     while(l < r){
    //         int p = partition(count, l, r);
    //         if(p == k){
    //             return;
    //         }else if(p < k){
    //             l = p + 1;
    //         }else{
    //             r = p - 1;
    //         }
    //     }
    // }
    // private int partition(Count[] count, int l, int r){
    //     int pivot = count[r].nums;
    //     int i = l-1;
    //     for(int j = l; j < r; j++){
    //         if(count[j].nums < pivot){
    //             swap(count, i+1, j);
    //             i++;
    //         }
    //     }
    //     swap(count, i+1, r);
    //     return i+1;
    // }
    // private void swap(Count[] count, int i, int j){
    //     Count tmp = count[i];
    //     count[i] = count[j];
    //     count[j] = tmp;
    // }
}

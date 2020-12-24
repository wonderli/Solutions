import java.util.*;
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int l = 0;
        int r = n - 1;
        while(l <=r ){
            int mid = helper(points, l, r);
            if(mid == K) break;
            else if(mid < K){
                l = mid +1;
            }else{
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int helper(int[][] points, int l, int r){
        int[] pivot = points[r];
        int i = l-1;
        int j = l;
        while(j <= r -1){
            if(compare(points[j], pivot) <= 0){
                swap(points, i+1, j);
                i++;        
            }
            j++;
        }
        swap(points, i+1, r);
        return i+1;
        
    }
    private void swap(int[][] points, int i, int j){
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
    private int compare(int[] p1, int[] p2){
        int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
        int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
        return dist1 - dist2;
    }
}

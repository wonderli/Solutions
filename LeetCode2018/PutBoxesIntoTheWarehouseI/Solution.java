import java.util.*;
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        
        int m = warehouse.length;
        int[] h = new int[m];
        h[0]  = warehouse[0];
        for(int i = 1; i < m; i++){
            if(warehouse[i] < h[i-1]){
                h[i] = warehouse[i];
            }else{
                h[i] = h[i-1];
            }
        }
        
        int i = m-1;
        int n = boxes.length;
        Arrays.sort(boxes);
        int j = 0;
        
        int count = 0;
        while(i >= 0 && j < n){
            if(boxes[j] <= h[i]){
                j++;
                i--;
                count++;
            }else{
                i--;
            }
        }
        return count;
    }
}
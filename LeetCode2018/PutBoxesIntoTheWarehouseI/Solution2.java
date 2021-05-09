import java.util.*;
class Solution{
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        for(int i = 1; i < warehouse.length; i++){
            warehouse[i] = Math.min(warehouse[i], warehouse[i-1]);
        }
        Arrays.sort(boxes);
        int count = 0;
        for(int i = warehouse.length - 1; i >= 0; i--){
            if(count < boxes.length && boxes[count] <= warehouse[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

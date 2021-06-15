import java.util.*;
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int result = 0;
        for(int i = 0; i < boxTypes.length; i++){
            int boxCount = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= boxCount;
            result += boxCount * boxTypes[i][1];
            if(truckSize == 0){
                break;
            }
        }
        return result;
        
    }
}

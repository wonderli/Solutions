import java.util.*;
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int result = 0;
        for(int i = 0; i < boxTypes.length; i++){
            for(int j = 0; j < boxTypes[i][0] && truckSize != 0; j++){
                result += boxTypes[i][1];
                truckSize--;
            }
        }
        return result;
        
    }
}

import java.util.*;
class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int count = 0;
        for(int e : data){
            count += e == 1 ? 1 : 0;
        }
        
        int slow = 0;
        int fast = 0;
        int maxOnes = 0;
        int currOnes = 0;
        while(fast < n){
            if(fast - slow < count){
                if(data[fast] == 1){
                    currOnes++;
                    maxOnes = Math.max(maxOnes, currOnes);
                }
                fast++;
            }else{
                if(data[slow] == 1){
                    currOnes--;
                }
                slow++;
            }
        }
        return count - maxOnes;
    }
}

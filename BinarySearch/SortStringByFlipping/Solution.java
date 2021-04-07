import java.util.*;

class Solution {
    public int solve(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] leftY = new int[n];
        int[] rightX = new int[n];
        leftY[0] = 0;
        rightX[n-1] = 0;
        for(int i = 1; i < n; i++){
            leftY[i] = leftY[i-1] + (s.charAt(i-1) == 'y' ? 1 : 0);
        }
        for(int i = n-2; i>=0; i--){
            rightX[i] = rightX[i+1] + (s.charAt(i+1) == 'x' ? 1 : 0);
        }
        int result = n;
        for(int i = 0; i < n; i++){
            result = Math.min(result, leftY[i] + rightX[i]);
        }
        return result;
    }
 }
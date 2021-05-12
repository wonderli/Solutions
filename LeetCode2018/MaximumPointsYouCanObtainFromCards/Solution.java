import java.util.*;
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = 0;
        for(int i = 0; i < k; i++){
            l += cardPoints[i];
        }
        int max = l;
        int r = 0;
        for(int i = 0; i < k; i++){
            l -= cardPoints[k - 1 - i];
            int j = n - 1 - i;
            r += cardPoints[j];
            max = Math.max(l + r, max);
        }
        return max;
    }
}

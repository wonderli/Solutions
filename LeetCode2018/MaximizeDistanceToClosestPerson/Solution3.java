import java.util.*;
public class Solution3{
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int last = -1;
        int n = seats.length;
        for(int i = 0; i< n; i++){
            if(seats[i] == 1){
                ans = last < 0 ?i: Math.max(ans, (i - last)/2);
                last = i;
            }
        }
        ans = Math.max(ans, n - last - 1);
        return ans;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
    }
}

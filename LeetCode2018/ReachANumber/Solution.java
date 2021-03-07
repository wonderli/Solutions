import java.util.*;
public class Solution{
    public int reachNumber(int target){
        target = Math.abs(target);
        int step = 0;
        int curr = 0;
        while(true){
            step++;
            curr = curr + step;
            if(curr == target){
                return step;
            }else if(curr > target && (curr - target) % 2 == 0){
                return step;
            }
        }
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

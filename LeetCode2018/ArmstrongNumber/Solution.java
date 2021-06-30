import java.util.*;
class Solution {
    public boolean isArmstrong(int n) {
        String s = Integer.toString(n);
        int k = s.length();
        int sum = 0;
        for(char c : s.toCharArray()){
            int x = 1;
            for(int i = 0; i < k; i++){
                x = x * (c - '0');
            
            }
            sum += x;
        }
        return n == sum;
    }
}

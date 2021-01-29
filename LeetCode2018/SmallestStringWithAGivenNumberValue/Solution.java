import java.util.*;
public class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >=0; i--){
            int x = Math.min(k - i, 26);
            char c = (char)(x + 'a' - 1);
            k = k - x;
            sb.append(c); 
        }
        sb.reverse();
        return sb.toString();
    }
}
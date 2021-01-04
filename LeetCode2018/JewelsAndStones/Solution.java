import java.util.*;
public class Solution{
    public int numJewelsInStones(String jewels, String stones) {
           int[] map = new int[256];
           for(char c : stones.toCharArray()){
               map[c]++;
           }
           int count = 0;
           for(char c : jewels.toCharArray()){
               count += map[c];
           }
           return count;
       }
}
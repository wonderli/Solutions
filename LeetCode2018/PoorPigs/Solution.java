import java.util.*;
public class Solution{
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest/minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets)/Math.log(states));
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

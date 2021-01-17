import java.util.*;
public class Solution{
    public int countVowelStrings(int n) {
        int[][] memo = new int[n+1][6];
        return count(n, 5, memo);
    }
    private int count(int n, int v, int[][] memos){
        if(v == 1) return 1;
        if(n == 1) return v;
        if(memos[n][v] != 0){
            return memos[n][v];
        }
        int result = count(n, v-1, memos) + count(n-1, v, memos);
        memos[n][v] = result;
        return result;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

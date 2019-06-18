import java.util.*;
public class Solution{
    public boolean isIsomorphic(String s, String t) {
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(sChar[s.charAt(i)] != tChar[t.charAt(i)]){
                return false;
            }
            sChar[s.charAt(i)] = i + 1;
            tChar[t.charAt(i)] = i + 1;
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "aab";
        String t = "bba";
        System.out.println(sol.isIsomorphic(s, t));
    }
}

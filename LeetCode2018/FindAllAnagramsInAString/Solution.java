import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();
        if(ns < np) return new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(char c : p.toCharArray()){
            pCount[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            sCount[s.charAt(i) - 'a']++;
            if(i >= np){
                sCount[s.charAt(i - np) - 'a' ]--;
            }
            if(Arrays.equals(pCount, sCount)){
                result.add(i - np + 1);
            }
        }
        return result;
    }
}

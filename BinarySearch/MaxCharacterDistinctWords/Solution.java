import java.util.*;
/**

Given a list of lowercase alphabetical strings words, return the maximum sum of the lengths of two distinct words that don't share a common letter.

Constraints

n ≤ 1,000 where n is the length of words
w ≤ 1,000 where w is the length of the longest string in words
Example 1
Input
words = ["abcde", "xyz", "abdexyz", "axyz"]
Output
8
Explanation
These two words don't share any common letters ["abcde", "xyz"]


*/
class Solution {
    public int solve(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            int val = 0;
            String w = words[i];
            int v = 0;
            for(char c : w.toCharArray()){
                int x = c - 'a';
                v |= (1 << x);
            }
            map.put(i, v);
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < i; j++){
                int v1 = map.get(i);
                int v2 = map.get(j);
                if((v1 & v2) == 0){
                    max = Math.max(max, words[i].length() + words[j].length());
                }
            }
        }
        return max;
    }

}
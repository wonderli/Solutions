import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int j = 0;
        int[] map = new int[26];
        for(int i = 0; i < n; i++){
            map[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < n; i++){
            j = Math.max(j, map[s.charAt(i)- 'a']);
            if(i == j){
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
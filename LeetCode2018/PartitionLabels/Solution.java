import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(S.charAt(i), i);
        }
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (j < n) {
            int last = map.get(S.charAt(j));
            int count = 0;
            while (i <= last) {
                int curr = map.get(S.charAt(i));
                if (curr > last) {
                    last = curr;
                }
                i++;
                count++;
            }
            result.add(count);
            
            j = i;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s ="ababcbacadefegdehijhklij";
        sol.partitionLabels(s);
    }
}
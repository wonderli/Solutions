import java.util.*;
import java.util.stream.Collectors;

public class Solution{
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 10) return res;
        Map<String, Integer> seen = new HashMap<>();
        int i = 0;
        int j = 10;
        while(i < s.length() && j <= s.length()){
            String curr = s.substring(i, j);
            int time = seen.getOrDefault(curr, 0);
            time += 1;
            seen.put(curr, time);
            i++;
            j++;
        }

        res = seen.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).collect(Collectors.toList());
        return res;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(sol.findRepeatedDnaSequences(s));
    }
}

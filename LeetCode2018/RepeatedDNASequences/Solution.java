import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) return new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n - 9; i++) {
            String curr = s.substring(i, i + 10);
            if (seen.contains(curr)) {
                res.add(curr);
            }
            seen.add(curr);
        }
        return new ArrayList<>(res);
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(sol.findRepeatedDnaSequences(s));
    }
}

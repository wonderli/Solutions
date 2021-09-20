import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    private class Pair {
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    Map<Pair, Integer> memo = new HashMap<>();
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        return helper(s, 0, t, 0);
    }
    private int helper(String s, int i, String t, int j){
        int sLen = s.length();
        int tLen = t.length();

        if(i == sLen || j == tLen || sLen - i < tLen - j){
            return j == tLen ? 1 : 0;
        }

        Pair key = new Pair(i, j);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int result = helper(s, i+1, t, j);
        
        if(s.charAt(i) == t.charAt(j)){
            result += helper(s, i+1, t, j+1);
        }
        memo.put(key, result);

        return result;
    }
}
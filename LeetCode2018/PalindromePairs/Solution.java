import java.util.*;
public class Solution{
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            String rw = new StringBuilder(w).reverse().toString();
            TrieNode curr = root;
            for(int j = 0; j < w.length(); j++){
                if(hasPalindromeRemaining(rw, j)){
                    curr.palindromePrefixRemaining.add(i);
                }
                char c = rw.charAt(j);
                if(!curr.children.containsKey(c)){
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.wordEnding = i;
        }
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String w = words[i];
            TrieNode curr = root;
            for(int j = 0; j < w.length(); j++){
                if(curr.wordEnding != -1 && hasPalindromeRemaining(w, j)){
                    pairs.add(Arrays.asList(i, curr.wordEnding));
                }
                char c = w.charAt(j);
                curr = curr.children.get(c);
                if(curr == null) break;
            }
            if(curr == null) continue;
            if(curr.wordEnding != -1 && curr.wordEnding != i){
                pairs.add(Arrays.asList(i, curr.wordEnding));
            }
            for(int other : curr.palindromePrefixRemaining){
                pairs.add(Arrays.asList(i, other));
            }
        }
        return pairs;
    }
    private boolean hasPalindromeRemaining(String s, int i){
        int p1 = i;
        int p2 = s.length() - 1;
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    int wordEnding = -1;
    List<Integer> palindromePrefixRemaining = new ArrayList<>();
}  

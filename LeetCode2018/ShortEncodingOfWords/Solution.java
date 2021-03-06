import java.util.*;
class Solution {
    private class Trie{
        Trie[] children = new Trie[26];
        int count;
        
        public Trie get(char c){
            if(children[c -'a'] == null){
                children[c - 'a'] = new Trie();
                count++;
            }
            return children[c - 'a'];
        }
    }
    public int minimumLengthEncoding(String[] words) {
        Map<Trie, Integer> map = new HashMap<>();
        Trie root = new Trie();
        for(int j = 0; j < words.length; j++){
            String w = words[j];
            Trie curr = root;
            for(int i = w.length() -1 ;i >= 0;i--){
                curr = curr.get(w.charAt(i));
            }
            map.put(curr, j);
        }
        int result = 0;
        for(Trie node : map.keySet()){
            if(node.count == 0){
                result += words[map.get(node)].length() + 1;
            }
        }
        return result;
    }
}

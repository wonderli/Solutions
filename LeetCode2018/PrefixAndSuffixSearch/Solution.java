import java.util.*;
class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class WordFilter {

    private class TrieNode{
        TrieNode[] children = new TrieNode[27];
        int weight = 0;
    }
    
    private TrieNode root;
    public WordFilter(String[] words) {
        root= new TrieNode();
        for(int weight = 0;  weight < words.length; weight++){
            String word = words[weight] + "{";
            for(int i = 0; i < word.length(); i++){
                TrieNode curr = root;
                curr.weight = weight;
                for(int j = i; j < 2 * word.length() - 1; j++){
                    int k = word.charAt(j % word.length()) - 'a';
                    if(curr.children[k] == null){
                        curr.children[k] = new TrieNode();
                    }
                    curr= curr.children[k];
                    curr.weight = weight;
                }
            }
        }
        
    }
    
    public int f(String prefix, String suffix) {
        TrieNode curr = root;
        for(char c : (suffix + '{' + prefix).toCharArray()){
            if(curr.children[c - 'a'] == null) return -1;
            curr = curr.children[c - 'a'];
        }
        return curr.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
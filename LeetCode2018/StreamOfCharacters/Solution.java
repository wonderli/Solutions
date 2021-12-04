import java.util.*;
class StreamChecker {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
    
    TrieNode root = new TrieNode();
    Deque<Character> stream = new ArrayDeque<>();
    
    public StreamChecker(String[] words) {
        for(String w : words){
            TrieNode curr = root;
            String reverse = new StringBuilder(w).reverse().toString();
            for(char c : reverse.toCharArray()){
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }
        
    }
    
    public boolean query(char letter) {
        stream.addFirst(letter);
        TrieNode curr= root;
        for(char c : stream){
            if(curr.isWord) {
                return true;
            }
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isWord;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

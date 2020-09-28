import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}
class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < wordArr.length; i++){
            char c = wordArr[i];
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            if(i == wordArr.length - 1){
                curr.children[c - 'a'].isEnd = true;
            }
            curr = curr.children[c - 'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < wordArr.length; i++){
            char c = wordArr[i];
            curr = curr.children[c - 'a'];
            if(curr == null) return false;
            if(i == wordArr.length - 1){
                return curr.isEnd;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] wordArr = prefix.toCharArray();
        for(int i = 0; i < wordArr.length; i++){
            char c = wordArr[i];
            curr = curr.children[c - 'a'];
            if(curr == null) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}



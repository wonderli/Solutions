import java.util.*;

public class Solution2 {
    public static void main(String args[]) {
        Solution2 sol = new Solution2();
        WordDictionary word = new WordDictionary();
        word.addWord("a");
        word.addWord("bad");
        word.addWord("dad");
        word.addWord("mad");
//        System.out.println(word.search("pad"));
//        System.out.println(word.search("bad"));
        System.out.println(word.search(".a"));
//        System.out.println(word.search(".ad"));
//        System.out.println(word.search("b.."));

    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return helper(0, word, root);
    }

    private boolean helper(int index, String word, TrieNode curr) {
        if(curr == null) return false;
        if (index == word.length()) return curr.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            return helper(index + 1, word, curr.children[c - 'a']);
        } else {
            TrieNode[] children = curr.children;
            for (int j = 0; j < 26; j++) {
                TrieNode d = curr.children[j];
                if (d == null) {
                    continue;
                }
                if (helper(index + 1, word, curr.children[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}





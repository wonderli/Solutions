import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.containsKey(c)){
                node = node.get(c);
            }else {
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode{
    TrieNode[] nodes;
    int size = 26;
    boolean isEnd;

    public TrieNode(){
        nodes = new TrieNode[size];
    }

    public boolean containsKey(char c){
        return nodes[c - 'a'] != null;
    }

    public TrieNode get(char c){
        return nodes[c - 'a'];
    }
    public void put(char c, TrieNode node){ 
        nodes[c - 'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

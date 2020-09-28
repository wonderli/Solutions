import java.util.*;
public class Solution2{
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
    static class MapSum {
        TrieNode root;
        Map<String, Integer> map;
        MapSum(){
            root = new TrieNode();
            map = new HashMap<>();
        }
        public void insert(String key, int val){
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode curr = root;
            curr.sum += delta;
            for(char c : key.toCharArray()){
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
                curr.sum += delta;
            }
        }
        public int sum(String prefix){
            TrieNode curr = root;
            for(char c : prefix.toCharArray()){
                curr = curr.children.get(c);
                if(curr == null) return 0;
            }
            return curr.sum;
        }
    }
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int sum;
    }
}

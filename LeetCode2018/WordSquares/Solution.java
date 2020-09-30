import java.util.*;
public class Solution{
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<>();
        if(words == null || words.length == 0) return ret;
        TrieNode root = build(words);
        int len = words[0].length();
        List<String> curr = new ArrayList<>();
        for(String w : words){
            curr.add(w);
            search(len, root, ret, curr);
            curr.remove(curr.size() - 1);
        }
        return ret;
    }
    private void search(int len, TrieNode root, List<List<String>> ret, List<String> curr){
        if(curr.size() == len){
            ret.add(new ArrayList<>(curr));
            return;
        }
        int index = curr.size();
        StringBuilder sb = new StringBuilder();
        for(String s : curr){
            sb.append(s.charAt(index));
        }
        List<String> startWith = findByPrefix(sb.toString(), root);
        for(String sw : startWith){
            curr.add(sw);
            search(len, root, ret, curr);
            curr.remove(curr.size() - 1);
        }
    }
    private TrieNode build(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode curr = root;
            for(char c : w.toCharArray()){
                if(curr.children[c - 'a'] == null){
                    TrieNode t = new TrieNode();
                    curr.children[c - 'a'] = t;
                }
                curr.children[c - 'a'].startWith.add(w);
                curr = curr.children[c - 'a'];
            }
        }
        return root;
    }
    private List<String> findByPrefix(String prefix, TrieNode root){
        List<String> ret = new ArrayList<>();
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null){
                return ret;
            }
            curr = curr.children[index];
        }
        ret.addAll(curr.startWith);
        return ret;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    List<String> startWith = new ArrayList<>();
}


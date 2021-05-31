import java.util.*;
class Solution {
    private class Trie{
        Trie[] children = new Trie[26];
        List<String> products = new ArrayList<>();
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = build(products);
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 1; i <= searchWord.length(); i++){
            String prefix = searchWord.substring(0, i);
            result.add(search(root, prefix));
        } 
        return result;
    }
    
    private List<String> search(Trie root, String prefix){
        List<String> result = new ArrayList<>();
        Trie curr = root;
        for(char c : prefix.toCharArray()){
            if(curr.children[c - 'a'] == null) return result;
            curr = curr.children[c-'a'];
        }
        for(int i = 0; i < Math.min(3, curr.products.size()); i++){
            result.add(curr.products.get(i));
        }
        return result;
    }
    private Trie build(String[] products){
        Arrays.sort(products);
        Trie root = new Trie();
        for(String p : products){
            Trie curr = root;
            for(char c : p.toCharArray()){
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new Trie();
                }
                curr = curr.children[c - 'a'];
                curr.products.add(p);
            }
        }
        return root;
    }
}

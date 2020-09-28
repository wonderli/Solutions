import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
        MapSum m = new MapSum();
        m.insert("aa", 3);
        System.out.println(m.sum("a"));
        m.insert("aa", 2);
        System.out.println(m.sum("a"));
        System.out.println(m.sum("aa"));
        m.insert("aaa", 3);
        System.out.println(m.sum("aaa"));
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
        int val = 0;
    }

    static class MapSum {
        TrieNode root;
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode curr = root;
            char[] arr = key.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(!curr.children.containsKey(arr[i])){
                    curr.children.put(arr[i], new TrieNode());
                }
                curr = curr.children.get(arr[i]);
            }
            curr.isEnd = true;
            curr.val = val;
        }

        public int sum(String prefix) {
            TrieNode curr = root;
            int sum = 0;
            char[] arr = prefix.toCharArray();
            for(int i = 0; i < arr.length; i++){
                curr = curr.children.get(arr[i]);
                if(curr == null) {
                    return 0;
                }

            }
            if(curr == null) return 0;
            sum = curr.isEnd ? curr.val : 0;
            Queue<TrieNode> queue = new LinkedList<>();
            queue.add(curr);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TrieNode c = queue.poll();
                    Map<Character, TrieNode> map = c.children;
                    for(Map.Entry<Character, TrieNode> entry : map.entrySet()){
                        TrieNode t = entry.getValue();
                        sum += t.isEnd? t.val : 0;
                        queue.add(t);
                    }
                }
            }
            return sum;
        }
    }
}




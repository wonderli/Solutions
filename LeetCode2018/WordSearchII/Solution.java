import java.util.*;
public class Solution{
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = build(words);
        Set<String> ret = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                helper(i, j, board, root, ret, visited);
            }
        }
        return new ArrayList<>(ret);
    }
    public void helper(int r, int c, char[][] board, TrieNode curr, Set<String> ret, boolean[][] visited){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || curr == null|| visited[r][c]){
            return;
        }
        if(!curr.children.containsKey(board[r][c])) return;
        curr = curr.children.get(board[r][c]);
        if(curr.isEnd){
            ret.add(curr.s);
        }
        visited[r][c] = true;
        helper(r - 1, c, board, curr, ret, visited); 
        helper(r + 1, c, board, curr, ret, visited); 
        helper(r , c - 1, board, curr, ret, visited); 
        helper(r , c + 1, board, curr, ret, visited); 
        visited[r][c] = false;
    }
    private TrieNode build(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode curr = root;
            for(char c : w.toCharArray()){
                if(!curr.children.containsKey(c)){
                    TrieNode t = new TrieNode();
                    curr.children.put(c, t);
                }
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
            curr.s = w;
        }
        return root;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
    String s;
}

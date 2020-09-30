import java.util.*;
public class Solution2{
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = build(words);
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                helper(i, j, board, root, ret );
            }
        }
        return new ArrayList<>(ret);
    }
    public void helper(int r, int c, char[][] board, TrieNode curr, List<String> ret ){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || curr == null|| board[r][c] == '#'){
            return;
        }
        if(curr.children[board[r][c] - 'a'] == null) return;
        curr = curr.children[ board[r][c] - 'a'];
        if(curr.isEnd){
            if(curr.s != null){
                ret.add(curr.s);
                curr.s = null;
            }
        }
        char ch = board[r][c];
        board[r][c] = '#';
        helper(r - 1, c, board, curr, ret); 
        helper(r + 1, c, board, curr, ret); 
        helper(r , c - 1, board, curr, ret); 
        helper(r , c + 1, board, curr, ret); 
        board[r][c] = ch;
    }
    private TrieNode build(String[] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode curr = root;
            for(char c : w.toCharArray()){
                if(curr.children[c - 'a'] == null ){
                    TrieNode t = new TrieNode();
                    curr.children[c - 'a'] = t;
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
            curr.s = w;
        }
        return root;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    String s;
}

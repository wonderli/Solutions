import java.util.*;

public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = build(dictionary);
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String r = replace(root, s[i]);
            if (r == null) {
                r = s[i];
            }
            sb.append(r);
            if (i < s.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String replace(TrieNode root, String s) {
        StringBuilder sb = new StringBuilder();
        TrieNode prev = null;
        TrieNode curr = root;
        boolean foundEnd = false;
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (curr.children.containsKey(c)) {
                if (curr.children.get(c).isEnd) {
                    return sb.toString();
                }
                curr = curr.children.get(c);
            } else {
                return s;
            }
        }
        return s;
    }

    public TrieNode build(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!curr.children.containsKey(c)) {
                    TrieNode t = new TrieNode();
                    curr.children.put(c, t);
                }
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
        }
        return root;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        List<String> s = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(sol.replaceWords(s, sentence));
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;
}

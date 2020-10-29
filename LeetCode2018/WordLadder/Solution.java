import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        for (String w : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = w.substring(0, i) + '*' + w.substring(i + 1, len);
                List<String> transformation = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformation.add(w);
                allComboDict.put(newWord, transformation);
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);


        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            String word = node.string;
            int level = node.level;
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
    }
}

class Pair {
    String string;
    Integer level;

    Pair(String string, Integer level) {
        this.string = string;
        this.level = level;
    }
}

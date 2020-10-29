import java.util.*;
public class Solution2{
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String w = queue.poll();
                if(w.equals(endWord)){
                    return level;
                }

                for(int j = 0; j < w.length(); j++){
                    char[] ch = w.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nw = String.valueOf(ch);
                        if(dict.contains(nw) && visited.add(nw)){
                            queue.add(nw);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

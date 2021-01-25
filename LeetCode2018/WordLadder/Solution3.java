import java.util.*;
public class Solution3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> currVisited = new HashSet<>();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                if(s.equals(endWord)){
                    return level;
                }
                List<String> nextS = getNext(s, dict, visited);
                queue.addAll(nextS);
                currVisited.addAll(nextS);
            }
            visited.addAll(currVisited);
            level++;
        }
        return 0;
    }
    
    private List<String> getNext(String s, Set<String> dict, Set<String> visited){
        List<String> result =new ArrayList<>();
        char[] cs = s.toCharArray();
        for(int i = 0; i <cs.length; i++){
            char t = cs[i];
            for(char c ='a'; c <= 'z'; c++){
                cs[i] = c;
                String newS = new String(cs);
                if(dict.contains(newS) && !visited.contains(newS)){
                    result.add(newS);
                }
            }
            cs[i] = t;
        }
        return result;
    }
}

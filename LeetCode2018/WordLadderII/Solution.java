import java.util.*;
public class Solution {
    private class Node{
        String word;
        List<String> path;
        public Node(String w, List<String> p){
            word = w;
            path = p;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if(!dict.contains(endWord)){
            return result;
        }
        
        Queue<Node> queue =new LinkedList<>();
        
        List<String> startPath = new ArrayList<>();
        startPath.add(beginWord);
        
        queue.add(new Node(beginWord, startPath));
                  
        Set<String> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            Set<String> visitedCurrent = new HashSet<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                String word = node.word;
                List<String> path = node.path;
                if(result.size() != 0 && path.size() > result.get(0).size()) break;
                
                if(word.equals(endWord)){
                    result.add(path);
                }else{
                    Set<String> nextWords = getNextWords(word, dict, visited);
                    for(String s : nextWords){
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(s);
                        queue.add(new Node(s, newPath));
                        visitedCurrent.add(s);
                    }
                }
            }
            visited.addAll(visitedCurrent);
        }
        return result;
    }
    
    private Set<String> getNextWords(String curr, Set<String> dict, Set<String> visited){
        Set<String> result = new HashSet<>();
        char[] cs = curr.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char t = cs[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == t) continue;
                cs[i] = c;
                String newString = new String(cs);
                if(dict.contains(newString) && !visited.contains(newString)){
                    result.add(newString);
                }
            }
            cs[i] = t;
        }
        return result;
    }
    
}

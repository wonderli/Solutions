import java.util.*;

class Solution3 {
    public String alienOrder(String[] words) {
        if(words.length < 1) return "";
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> adjacentMap = new HashMap<>();
        for(String s : words){
            for(char c : s.toCharArray()){
                indegree.put(c, 0);
                adjacentMap.put(c, new ArrayList<>());
            }
        }
        int len = words.length;
        for(int i = 0; i < len-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            if(isPrefix(w2, w1)){
                return "";
            }

            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2){
                    indegree.put(c2, indegree.get(c2)+1);
                    List<Character> list = adjacentMap.get(c1);
                    list.add(c2);
                    adjacentMap.put(c1, list);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0){
                queue.add(c);

            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            List<Character> list = adjacentMap.get(c);
            for(char e : list){
                int val = indegree.get(e);
                val--;
                indegree.put(e, val);
                if(val == 0){
                    queue.add(e);
                }
            }
        }
        if(sb.length() == indegree.size()){
            return sb.toString();
        }else{
            return "";
        }

    }

    private boolean isPrefix(String w2, String w1){
        return w2.length() < w1.length() && w1.startsWith(w2);
    }
}
import java.util.*;
class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1List = map.get(word1);
        List<Integer> w2List = map.get(word2);
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right =0;
        while(left < w1List.size() && right < w2List.size()){
            min = Math.min(min, Math.abs(w1List.get(left) - w2List.get(right)));
            if (w1List.get(left) < w2List.get(right)) {
                left ++;
            } else {
                right++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

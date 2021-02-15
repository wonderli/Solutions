import java.util.*;
public class Solution3 {
    Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(cache.containsKey(s)){
            return cache.get(s);
        }
        List<String> result = new ArrayList<>();
        if(s.isEmpty()){
            result.add("");
            return result;
        }
        
        for(String w : wordDict){
            if(s.startsWith(w)){
                List<String> subList = wordBreak(s.substring(w.length()), wordDict);
                for(String sub : subList){
                    result.add(w + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}

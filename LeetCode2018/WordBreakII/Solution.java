import java.util.*;
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        List<String> res = new LinkedList<>();
        if(wordDict.contains(s)){
            res.add(s);
        }
        for(int i = 1; i < s.length(); i++){
            String left = s.substring(0, i);
            if(wordDict.contains(left)){
                for(String ss : wordBreak(s.substring(i), wordDict)){
                    res.add(left + " " + ss);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
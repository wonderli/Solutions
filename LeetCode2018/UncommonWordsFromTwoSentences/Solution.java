import java.util.*;
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] aa = A.split(" ");
        String[] bb = B.split(" ");
        Map<String, Integer> aMap = new HashMap<>();
        for(String e : aa){
            aMap.put(e, aMap.getOrDefault(e, 0) + 1);
        }
        Map<String, Integer> bMap = new HashMap<>();
        for(String e : bb){
            bMap.put(e, bMap.getOrDefault(e, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for(String e : aa){
            if(aMap.get(e) == 1 && !bMap.containsKey(e)){
                result.add(e);
            }
        }
        for(String e : bb){
            if(bMap.get(e) == 1 && !aMap.containsKey(e)){
                result.add(e);
            }
        }
        String[] res = new String[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }
}

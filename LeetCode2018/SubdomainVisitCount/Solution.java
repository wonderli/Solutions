import java.util.*;
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : cpdomains){
            String[] array = s.split("\\s+");
            int count = Integer.parseInt(array[0]);
            int len = array[1].length();
            map.put(array[1], map.getOrDefault(array[1], 0)+count);
            
            for(int i = 0; i < len; i++){
                if(array[1].charAt(i) == '.'){
                    String tmp = array[1].substring(i+1, len);
                    map.put(tmp, map.getOrDefault(tmp, 0) + count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(String k : map.keySet()){
            String res = String.format("%d %s", map.get(k), k);
            result.add(res);
        }
        return result;
    }
}

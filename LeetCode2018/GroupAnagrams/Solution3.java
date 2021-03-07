import java.util.*;
class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String sc = Arrays.toString(cs);
            if(!map.containsKey(sc)){
                List<String> l = new ArrayList<>();
                map.put(sc, l);
            }
            map.get(sc).add(s);
        }
        List<List<String>> ret = new ArrayList<>();
        ret.addAll(map.values());
        return ret;
    }
    public static void main(String args[]){
    }
}

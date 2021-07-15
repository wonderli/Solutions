import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        char[] cs = str.toCharArray();
        Character[] ccs = new Character[cs.length];
        for(int i = 0; i < cs.length; i++){
            ccs[i] = cs[i];
        }
        Arrays.sort(ccs, ((a, b) -> map.getOrDefault(a, 27) - map.getOrDefault(b, 27)));
        StringBuilder sb = new StringBuilder();
        for(char e : ccs){
            sb.append(e);
        }
        return sb.toString();
        
    }
}
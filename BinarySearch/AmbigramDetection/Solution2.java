import java.util.*;

class Solution {
    public boolean solve(String s, String[][] pairs) {
        Map<String, String> map = new HashMap<>();
        for(String[] p: pairs){
            String a = p[0];
            String b = p[1];
            String pa = find(map, a);
            String pb = find(map, b);
            if(pa == null || pb == null || !pa.equals(pb)){
                map.put(pa, pb);
            }
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char a = s.charAt(i);
            char b= s.charAt(j);
            if(a != b){
                String pa = find(map, Character.toString(a));
                String pb = find(map, Character.toString(b));
                if(pa == null || pb == null || !pa.equals(pb)){
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    private String find(Map<String, String> map, String x){
        String v = map.get(x);
        if(v == null){
            return x;
        }
        return find(map, v);
    }
}
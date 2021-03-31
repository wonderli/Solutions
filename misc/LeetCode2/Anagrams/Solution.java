import java.util.*;
public class Solution{
    public ArrayList<String> anagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<String>();
        ArrayList<String> ret = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        int len = strs.length;
        for(int i = 0; i < len; i++){
            char e[] = strs[i].toCharArray();
            Arrays.sort(e);
            String a = new String(e);
            if(map.containsKey(a)){
                map.get(a).add(strs[i]);
            }else{
                ArrayList<String> x = new ArrayList<String>();
                x.add(strs[i]);
                map.put(a, x);
            }
        }
        Set<String> set = map.keySet();
        for(String e : set){
            if(map.get(e).size() > 1){
                ret.addAll(map.get(e));
            }
        }
        return ret;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

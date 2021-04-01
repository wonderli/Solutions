import java.util.*;
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        if(stamp.equals(target)) return new int[]{0};
        
        char[] sc = stamp.toCharArray();
        char[] tc = target.toCharArray();
        int sLen = sc.length;
        int tLen = tc.length - sLen + 1;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        boolean tdiff = true;
        boolean sdiff = false;
        while(tdiff){
            for(i = 0, tdiff = false; i < tLen; i++){
                for(j = 0, sdiff= false; j < sLen; j++){
                    if(tc[i+j] == '*') continue;
                    else if(tc[i+j] != sc[j]) break;
                    else sdiff = true;
                }
                if(j == sLen && sdiff){
                    for(j = i, tdiff = true; j < sLen + i; j++){
                        tc[j] = '*';
                    }
                    list.add(0, i);
                }
            }
        }
        for(i = 0; i < tc.length; i++){
            if(tc[i] != '*') return new int[]{};
        }
        int[] result = new int[list.size()];
        for(i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}

import java.util.*;
class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            String result = s;
            for(int i = 0; i < s.length(); i++){
                String curr = s.substring(i) + s.substring(0, i);
                if(curr.compareTo(result) < 0){
                    result = curr;
                }
            }
            return result;
        }else{
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}

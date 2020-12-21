import java.util.*;
class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int n = S.length();
        for(int i = 0; i < n; i++){
            char c = S.charAt(i);
            if(Character.isDigit(c)){
                size *= Character.getNumericValue(c);
            }else{
                size++;
            }
        }
        for(int i = n - 1; i >= 0; i--){
            char c = S.charAt(i);
            K %= size;
            if(K == 0 && Character.isLetter(c)){
                return Character.toString(c);
            }
            if(Character.isDigit(c)){
                size /= Character.getNumericValue(c);
            }else{
                size--;
            }
        }
        return "";
    }
}

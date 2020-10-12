import java.util.*;
public class Solution2{
    public int titleToNumber(String s) {
        int res= 0;
        if(s == null || s.length() == 0) return 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int a = c - 'A' +1;
            res = res * 26 + a;
        }
        return res;
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

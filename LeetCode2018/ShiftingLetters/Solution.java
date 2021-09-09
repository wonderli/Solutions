import java.util.*;
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int sum = 0;
        for(int i = n-1; i>= 0; i--){
            sum = (sum + shifts[i])%26;
            int d = s.charAt(i) - 'a';
            int e = (d + sum)%26;
            sb.append((char)(e + 'a'));
        }
        return sb.reverse().toString();
    }
}
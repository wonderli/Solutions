import java.util.*;
class Solution {
    public String originalDigits(String s) {
        int[] output = new int[10];
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        output[0] = map['z' - 'a'];
        output[2] = map['w' - 'a'];
        output[4] = map['u' - 'a'];
        output[6] = map['x' - 'a'];
        output[8] = map['g' - 'a'];
        
        output[7] = map['s' - 'a'] - output[6];
        
        output[5] = map['f' - 'a'] - output[4];
        
        output[1] = map['o' - 'a'] - output[2] - output[4] - output[0];
        
        output[3] = map['h' - 'a'] - output[8];
        output[9] = map['i' - 'a'] - output[8] - output[5] - output[6];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < output[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}

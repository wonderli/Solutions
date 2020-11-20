import java.util.*;
class Solution {
    public String decodeString(String s) {
        if(s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i <s.length()){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                sb.append(c);
                i++;
            }else if(Character.isDigit(c)){
                j = i+1;
                int times = c - '0';
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    times = times * 10+ (s.charAt(j) - '0');
                    j++;
                }
                if(s.charAt(j) == '['){
                    int left = 1;
                    j++;
                    int start = j;
                    while(j < s.length() && left != 0){
                        if(s.charAt(j) == '['){
                            left++;
                        }else if(s.charAt(j) == ']'){
                            left--;
                        }
                        j++;
                    }
                    String sub = decodeString(s.substring(start, j-1));
                    for(int k=0; k<times;k++){
                        sb.append(sub);
                    }
                }
                i = j;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc3[[][][a]]xyz";
        System.out.println(sol.decodeString(s));
    }
}
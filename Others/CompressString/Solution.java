import java.util.*;
public class Solution{
    public static String compression(String str){
        StringBuilder sb = new StringBuilder();
        char[] s = str.toCharArray();
        int last = 0;
        int len = s.length;
        int count = 1;
        if(compressionCount(str) > str.length()) return str;
        for(int i = 1; i < len; i++){
            if(s[i] == s[last]){
                count++;
            }else{
                sb.append(count);
                sb.append(s[last]);
                last = i;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s[last]);
        return sb.toString();
    }
    public static int compressionCount(String str){
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }
    public static void main(String args[]){
        String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbccccccc";
        System.out.println(compressionCount(a));
        System.out.println(compression(a));
    }
}

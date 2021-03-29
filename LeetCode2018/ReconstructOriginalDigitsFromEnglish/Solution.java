import java.util.*;
class Solution {
    public String originalDigits(String s) {
        int n = s.length();
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        while(map['z' - 'a'] != 0){
            for(char c : "zero".toCharArray()){
                map[c - 'a']--;
            }
            list.add(0);
        }
        while(map['w' - 'a'] != 0){
            for(char c : "two".toCharArray()){
                map[c - 'a']--;
            }
            list.add(2);
        }
        while(map['x' - 'a'] != 0){
            for(char c : "six".toCharArray()){
                map[c - 'a']--;
            }
            list.add(6);
        }
        
        while(map['s' - 'a'] != 0){
            for(char c : "seven".toCharArray()){
                map[c - 'a']--;
            }
            list.add(7);
        }
        
        while(map['v' - 'a'] != 0 ){
            for(char c : "five".toCharArray()){
                map[c - 'a']--;
            }
            list.add(5);
        }
        
        while(map['f' - 'a'] != 0){
            for(char c : "four".toCharArray()){
                map[c - 'a']--;
            }
            list.add(4);
        }
        
        while(map['o' - 'a'] != 0){
            for(char c : "one".toCharArray()){
                map[c - 'a']--;
            }
            list.add(1);
        }
        while(map['r' - 'a'] != 0){
            for(char c : "three".toCharArray()){
                map[c - 'a']--;
            }
            list.add(3);
        }
        
        while(map['n' - 'a'] != 0){
            for(char c : "nine".toCharArray()){
                map[c - 'a']--;
            }
            list.add(9);
        }
        while(map['t' - 'a'] != 0){
            for(char c : "eight".toCharArray()){
                map[c - 'a']--;
            }
            list.add(8);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int e : list){
            sb.append(e);
        }
        return sb.toString();
        
        
    }
}

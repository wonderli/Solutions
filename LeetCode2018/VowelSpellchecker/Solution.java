import java.util.*;
class Solution {
    Set<String> wordsPerfect;
    Map<String, String> wordsLow;
    Map<String, String> wordsVow;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        wordsPerfect = new HashSet<>();
        wordsLow = new HashMap<>();
        wordsVow = new HashMap<>();
        for(String w : wordlist){
            wordsPerfect.add(w);
            wordsLow.putIfAbsent(w.toLowerCase(), w);
            String wordsVowDv = devowel(w);
            wordsVow.putIfAbsent(wordsVowDv, w);
        }
        String[] result = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            result[i] = solve(queries[i]);
        }
        return result;
    }
    
    private String solve(String s){
        if(wordsPerfect.contains(s)){
            return s;
        }
        String ls = s.toLowerCase();
        if(wordsLow.containsKey(ls)){
            return wordsLow.get(ls);
        }
        String dv = devowel(s);
        if(wordsVow.containsKey(dv)){
            return wordsVow.get(dv);
        }
        return "";
    }
    private String devowel(String s){
        String ls = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : ls.toCharArray()){
            if(isVowel(c)){
                sb.append("*");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char c){
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        return set.contains(c);
    }
}

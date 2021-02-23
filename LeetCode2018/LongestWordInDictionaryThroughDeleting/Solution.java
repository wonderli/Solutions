import java.util.*;
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String e : d){
            if(isSubSequence(s, e)){
                if(e.length() > result.length() ||(e.length() == result.length() && e.compareTo(result)<0)){
                    result = e;
                }
            }
        }
        return result;
    }
    private boolean isSubSequence(String a, String b){
        int j = 0;
        for(int i = 0; i < a.length() && j < b.length(); i++){
            if(a.charAt(i) == b.charAt(j)){
                j++;
            }
        }
        return j == b.length();
    }
}

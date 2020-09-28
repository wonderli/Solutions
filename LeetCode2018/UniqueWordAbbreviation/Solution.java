import java.util.*;
public class Solution{
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

class ValidWordAbbr {

    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {

        for (String s : dictionary) {
            String abb = abb(s);
            if(map.containsKey(abb)){
                if(!map.get(abb).equals(s)){
                    map.put(abb, "");
                }
            }else {
                map.put(abb, s);
            }
        }
    }
    public String abb(String s){
        if(s.length() <=2) return s;
        String abb = s.charAt(0) + Integer.toString((s.length() - 2)) + s.charAt(s.length() - 1);
        return abb;
    }

    public boolean isUnique(String word) {
        String s = abb(word);
        if(map.containsKey(s)){
            String b = map.get(s);
            return b.equals(word);
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

import java.util.*;
public class Q5{
    public static ArrayList<String> getPermutation(String s) {
        ArrayList<String> perm = new ArrayList<String>();
        if(s == null) return null;
        if(s.length() == 0){
            perm.add("");
            return perm;
        }
        char first = s.charAt(0);
        String remainder = s.substring(1);
        ArrayList<String> words = getPermutation(remainder);
        for(String word : words) {
            for(int j = 0; j <= word.length(); j++) {
                String x = insert(word, first, j);
                perm.add(x);
            }
        }
        return perm;
    }
    public static HashSet<String> another(String s) {
        HashSet<String> set = new HashSet<String>();
        if(s.length() == 0) {
            set.add("");
            return set;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String newStr = removeChar(s, i);
            HashSet<String> newSet = another(newStr);
            for(String e : newSet) {
                set.add(c + e);
            }
        }
        return set;
    }
    public static String removeChar(String s, int i) {
        if(i == 0) {
            return s.substring(1);
        }
        else{
            String left = s.substring(0,i);
            String right = s.substring(i + 1);
            return left+right;
        }
    }
    public static String insert(String word, char insert, int begin){
        String first = word.substring(0, begin);
        String second = word.substring(begin);
        return first + insert + second;
    }
    public static void main(String args[]) {
        String s = new String("abcd");
        System.out.println(getPermutation(s));
        //for(int i = 0; i < s.length(); i++) {
        //    System.out.println(removeChar(s, i));
        //}
        System.out.println(another(s));

    }
}

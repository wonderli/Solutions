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
    public static String insert(String word, char insert, int begin){
        String first = word.substring(0, begin);
        String second = word.substring(begin);
        return first + insert + second;
    }
    public static void main(String args[]) {
        String s = new String("xyl");
        System.out.println(getPermutation(s));
    }
}

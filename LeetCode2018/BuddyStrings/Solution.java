import java.util.*;
public class Solution{
    public boolean buddyStrings(String A, String B) {
        if(A == null || B == null || A.length() == 0 || B.length() == 0 || A.length() != B.length()) return false;
        int m = -1;
        int n = -1;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);
            if(a != b){
                if(m == -1){
                    m = i;
                }else if(n == -1){
                    n = i;
                }else{
                    return false;
                }
            }
            set.add(a);
        }
        if(m != -1 && n != -1){
            return A.charAt(m) == B.charAt(n) && A.charAt(n) == B.charAt(m);
        }
        if(m != -1){
            return false;
        }

        // A and B are same, check if any duplicates avaiable
        return set.size() < A.length();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

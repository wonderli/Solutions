import java.util.*;
public class Main{
    public static String check(String a, String b){
        if(a.length() != b.length()) return "NO";
        a = a.toUpperCase();
        b = b.toUpperCase();
        char s1[] = a.toCharArray();
        char s2[] = b.toCharArray();
        int len1 = a.length();
        int len2 = b.length();
        int first[] = new int[26];
        int second[] = new int[26];
        for(int i = 0; i < len1; i++){
            first[s1[i] - 'A']++;
        }
        for(int i = 0; i < len2; i++){
            second[s2[i] - 'A']++;
        }
        Arrays.sort(first);
        Arrays.sort(second);
        for(int i = 0; i < 26; i++){
            if(first[i] != second[i]){
                return "NO";
            }
        }
        return "YES";

    }
    public static void main(String args[]){
        Main sol = new Main();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(check(a, b));
    }
}

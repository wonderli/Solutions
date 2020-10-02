import java.util.*;
public class Solution2{
    Map<Character, Integer> map = new HashMap<>();
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    Map<Character, Set<Character>> sub = new HashMap<>();
    {
        Set<Character> s1 = new HashSet<>();
        s1.add('V');
        s1.add('X');
        sub.put('I', s1); 
        Set<Character> s2 = new HashSet<>();
        s2.add('L');
        s2.add('C');
        sub.put('X', s2);
        Set<Character> s3 = new HashSet<>();
        s3.add('D');
        s3.add('M');
        sub.put('C', s3);
    }
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char curr =s.charAt(i);
            int value = map.get(curr);
            if(i < s.length() - 1){
                char next = s.charAt(i + 1);
                if(shouldSub(curr, next)){
                    value = -1 * value;
                }
            }
            res += value;
        }
        return res;
    }
    public boolean shouldSub(char curr, char next){
        return sub.containsKey(curr) && sub.get(curr).contains(next);
    }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
    }
}

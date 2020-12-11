import java.util.*;

public class Solution3 {

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

    public int romanToInt(String s) {
        int result = 0;
        int tmp = 0;
        for (char c : s.toCharArray()) {
            int curr = map.get(c);
            if (curr > tmp) {
                tmp = curr - tmp;
            } else {
                result += tmp;
                tmp = curr;
            }
        }
        return result + tmp;
    }

    public static void main(String args[]) {
        Solution3 sol = new Solution3();
    }
}
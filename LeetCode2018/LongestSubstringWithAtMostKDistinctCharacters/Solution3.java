import java.util.*;
public class Solution3{
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int max = 0;
		while(j < n){
			map.put(s.charAt(j), j);
			if(map.size() > k){
				int min = Collections.min(map.values());
				map.remove(s.charAt(min));
				i = min+1;
			}
			max = Math.max(max, j - i+1);
			j++;
		}
		return max;
	}
	public static void main(String args[]){
		Solution3 sol = new Solution3();
	}
}

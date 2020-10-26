import java.util.*;
public class Solution{
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k== 0){
        	return 0;
        }
		Map<Character, Integer> map = new HashMap<>();
		int max = 1;
		int i =0;
		int j = 0;
		while(i < s.length()){
			if(map.size() <= k){
				map.put(s.charAt(i), i);
				i++;
			}
			if(map.size() > k){
				int min = s.length() - 1;
				for(int e : map.values()){
					min = Math.min(e, min);
				}
				map.remove(s.charAt(min));
				j = min + 1;
			}
			max = Math.max(max, i-j);
		}
		
        return max;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

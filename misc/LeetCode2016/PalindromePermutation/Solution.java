import java.util.*;
public class Solution{
	public boolean canPermutePalindrome(String s){
		if(s == null || s.length() == 0) return false;
		char sArr[] = s.toCharArray();
		int len = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < len; i++){
			if(map.containsKey(sArr[i])){
				int val = map.get(sArr[i]);
				map.put(sArr[i],val+1); 
			}else{
				map.put(sArr[i], 1);
			}
		}
		if(len%2 == 0){
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				if(entry.getValue() % 2 != 0){
					return false;
				}
			}
		}else {
			int counter = 0;
			for(Map.Entry<Character, Integer> entry : map.entrySet()){
				if(entry.getValue() % 2 != 0){
					counter++;
				}
				if(counter > 1) return false;
			}
		}

		return true;
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "code";
		System.out.println(sol.canPermutePalindrome(s));
		s = "aab";
		System.out.println(sol.canPermutePalindrome(s));
		s = "carerac";
		System.out.println(sol.canPermutePalindrome(s));
	}
}

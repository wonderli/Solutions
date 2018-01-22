import java.util.*;
public class Solution{
	public boolean isAnagram(String s, String t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		int sLen = s.length();
		int tLen = t.length();
		if(sLen != tLen) return false;
		char sArr[] = s.toCharArray();
		char tArr[] = t.toCharArray();
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		for(int i = 0; i < sLen; i++){
			if(sArr[i] != tArr[i]) return false;
		}
		return true;

	}
	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "anagram";
		String t = "nagaram";
		System.out.println(sol.isAnagram(s, t));

	}
}

import java.util.*;
public class Solution {
	public String removeDuplicates(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
		int n = s.length();
		int[] count = new int[n];
		for(int i = 0; i < sb.length(); i++){
			if(i == 0 || (sb.charAt(i) != sb.charAt(i-1))){
				count[i] = 1;
			}else{
				count[i] = count[i-1]+1;
				if(count[i] == k){
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				}
			}
		}
		return sb.toString();
	}
}

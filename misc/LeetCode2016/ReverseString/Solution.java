import java.util.*;
public class Solution{
	public String reverseString(String s) {
		if(s == null) return null;
		char[] arr = s.toCharArray();
		int len = s.length();
		int i = 0;
		int j = len-1;
		while(i < j) {
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		return new String(arr);
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "hello";
		System.out.println(sol.reverseString(s));
	}
}

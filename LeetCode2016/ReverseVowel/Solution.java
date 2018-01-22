import java.util.*;
public class Solution{
	public static Set<Character> vowel = new HashSet<Character>();
	{
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
		vowel.add('A');
		vowel.add('E');
		vowel.add('I');
		vowel.add('O');
		vowel.add('U');
	}
	public String reverseVowels(String s) {
		if(s == null || s.length() == 0) return s;
		int len = s.length();
		int i = 0;
		int j = len - 1;
		char arr[] = s.toCharArray();
		while(i < j) {
			if(vowel.contains(arr[i]) && vowel.contains(arr[j])){
			       	swap(arr, i, j);
				i++;
				j--;
			}
			if (!vowel.contains(arr[i])) i++;
			if (!vowel.contains(arr[j])) j--;
		}
		return new String(arr);
	}
	public void swap(char[] arr, int i, int j){
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "hello";
		System.out.println(sol.reverseVowels(s));
	}
}


import java.util.*;
public class Solution{
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null||words.length == 0) return 0;
		int len = words.length;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++){
			if(words[i].equals(word1)){
				int sd = shortestDistance(words, word1, word2, i);
				min = sd < min ? sd : min;
			}
		}
		return min;
	}
	public int shortestDistance(String[] words, String word1, String word2, int start){
		int len = words.length;
		int counter = 1;
		int min = Integer.MAX_VALUE;
		for(int i = start + 1 ; i < len; i++){
			if(words[i].equals(word2)){
				min = counter;
				break;
			}
			counter++;
		}
		counter = 1;
		for(int i = start - 1; i >= 0; i--){
			if(words[i].equals(word2)){
				min = counter < min ? counter : min;
				break;
			}
			counter++;
		}
		return min;

	}

	public static void main(String args[]){
		Solution sol = new Solution();
		String s[] = {"a","a","b","b"};
		System.out.println(sol.shortestDistance(s, "a", "b"));
		String s2[] = {"a", "b"};
		System.out.println(sol.shortestDistance(s2, "a", "b"));
		String s3[] = {"a", "b"};
		System.out.println(sol.shortestDistance(s3, "b", "a"));
	}
}

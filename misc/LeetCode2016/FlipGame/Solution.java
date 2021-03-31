import java.util.*;
public class Solution{
	public List<String> generatePossibleNextMoves(String s) {
		if(s == null || s.length() == 0) return new ArrayList<String>();
		char arr[] = s.toCharArray();
		int len = arr.length;
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < len - 2; i++){
			if(canFlip(arr, i)){
				set.add(flip(arr, i));
			}
		}
		for(int i = len - 1; i >= 1; i--){
			if(canFlipReverse(arr,i)){
				set.add(flipReverse(arr,i));
			}
		}
		return new ArrayList<String>(set);

	}
	public boolean canFlip(char arr[], int i){
		if((arr[i] == arr[i+1]) && (arr[i] == '+')) return true;
		return false;
	}
	public boolean canFlipReverse(char arr[], int i){
		if((arr[i] == arr[i-1]) && (arr[i] == '+')) return true;
		return false;
	}
	public String flip(char arr[], int i){
		char newArr[] = Arrays.copyOf(arr, arr.length);
		if(newArr[i] == '+') {
			newArr[i] = '-';
			newArr[i+1] = '-';
		}else {
			newArr[i] = '+';
			newArr[i+1] = '+';
		}
		return new String(newArr);
	}

	public String flipReverse(char arr[], int i){
		char newArr[] = Arrays.copyOf(arr, arr.length);
		if(newArr[i] == '+') {
			newArr[i] = '-';
			newArr[i-1] = '-';
		}else {
			newArr[i] = '+';
			newArr[i-1] = '+';
		}
		return new String(newArr);
	}

	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "++++";
		System.out.println(sol.generatePossibleNextMoves(s));
		s = "--";
		System.out.println(sol.generatePossibleNextMoves(s));
		s = "-+";
		System.out.println(sol.generatePossibleNextMoves(s));
	}
}

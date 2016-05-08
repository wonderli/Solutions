import java.util.*;
public class Solution{
	public boolean canWinNim(int n) {
		return (n % 4 != 0);

	}

	public static void main(String args[]){
		Solution sol = new Solution();
		int  n = 4;
		System.out.println(sol.canWinNim(n));
	}
}

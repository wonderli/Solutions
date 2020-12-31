import java.util.*;
public class Solution3{
	public int reverse(int x) {
		int result = 0;
		while(x != 0){
			if(result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10){
				return 0;
			}
			int a = x%10;
			x = x / 10;
			result = result * 10 + a;
		}
		return result;
	}
	public static void main(String args[]){
		Solution3 sol = new Solution3();
	}
}

//addDigits2()
//Wikipeida Digial root
import java.util.*;
public class Solution{
	public int addDigits(int num) {
		if (num%10 == num) return num;
		int x = 0;
		while(num/10 != num){
			x = x + num%10;
			num = num/10;
		}
		return addDigits(x);
	}
	public int addDigits2(int num){
		return num - 9 * ((num - 1)/9);

	}

	public static void main(String args[]){
		Solution sol = new Solution();
		int num = 38;
		System.out.println(sol.addDigits(num));
		System.out.println(sol.addDigits2(num));
		num = 44;
		System.out.println(sol.addDigits(num));
		System.out.println(sol.addDigits2(num));
	}
}

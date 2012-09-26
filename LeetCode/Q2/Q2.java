//  Determine whether an integer is a palindrome. Do this without extra space.
import java.io.*;
public class Q2{
    public static int reverseInteger(int num) {
        int inv = 0;
        while(num > 0){
            inv = inv * 10 + num % 10;
            num = num / 10;
        }
        return inv;
    }
    public static boolean checkPalindrome(int num) {
        int rev = reverseInteger(num);
        return (num - rev == 0) ? true : false;
    }
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String n = null;
            try{
                n = br.readLine();
            } catch(IOException e){
                System.err.print("IO Exception");
                System.exit(1);
            } 
            int num = Integer.parseInt(n);
            System.out.println(checkPalindrome(num));
        }
    }
}


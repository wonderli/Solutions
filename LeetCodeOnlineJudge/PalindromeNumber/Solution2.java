//Determine whether an integer is a palindrome. Do this without extra space.
public class Solution2{
     public boolean isPalindrome(int x) {
         if(x < 0){
             return false;
         }
         int div = 1;
         while(x/div >= 10){
             div *= 10;
         }
         while(x != 0){
             int l = x / div;
             int r = x % 10;
             if(l != r) return false;
             x = (x % div)/10;
             div /= 100;
         }
         return true;
     }
    public static void main(String args[]){
        Solution2 sol = new Solution2();
        int x = 1221;
        System.out.println(sol.isPalindrome(x));
    }
}

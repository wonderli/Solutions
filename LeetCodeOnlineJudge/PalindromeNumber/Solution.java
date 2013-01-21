//Determine whether an integer is a palindrome. Do this without extra space.
public class Solution{
     public boolean isPalindrome(int x) {
         if(x < 0){
             return false;
         }
         int count = 0;
         int a = x;
         while(a != 0){
             a = a / 10;
             count++;
         }
         int div1 = 1;
         int div2 = 10;
         while(count >= 1){
             int size = count;
             div1 = 1;
             while(size != 1){
                 div1 = div1 * 10;
                 size--;
             }
             int y = x / div1;
             int z = x % div2;
             x = x - y * div1;
             x = x/div2;
             count = count - 2;
             if(y != z){
                 return false;
             }
         }
         return true;
     }
    public static void main(String args[]){
        Solution sol = new Solution();
        int x = -2147447412;
        System.out.println(sol.isPalindrome(x));
    }
}

import java.util.*;
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] a = num1.split("\\+|i");
        String[] b= num2.split("\\+|i");
        int a1 = Integer.parseInt(a[0]);
        int b1 = Integer.parseInt(b[0]);
        int a2 = Integer.parseInt(a[1]);
        int b2 = Integer.parseInt(b[1]);
        return (a1 * b1 - a2 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
    }
}

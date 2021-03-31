import java.util.*;
public class Solution{
    public String intToRoman(int num) {
        String ones[]= {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String thousands[] = {"", "M", "MM", "MMM"};
        String t = thousands[num/1000];
        num = num%1000;
        String h = hundreds[num/100];
        num = num%100;
        String e = tens[num/10];
        num = num%10;
        String o = ones[num];
        return t + h + e + o;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}

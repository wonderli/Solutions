//Given an integer, convert it to a roman numeral.
//
//Input is guaranteed to be within the range from 1 to 3999.
public class Solution{
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String huns[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        while(num >= 1000){
            num -= 1000;
            sb.append("M");
        }
        String h = huns[num/100];
        num = num %100;
        String t = tens[num/10];
        num = num % 10;
        String o = ones[num];
        sb.append(h);
        sb.append(t);
        sb.append(o);
        return sb.toString();
    }
    public static void main(String args[]){
        int num = 3224;
        Solution s = new Solution();
        System.out.println(s.intToRoman(num));
    }
}

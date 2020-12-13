import java.util.*;
class Solution {
    public String intToRoman(int num) {
        if(num == 0) return "";
        StringBuilder sb = new StringBuilder();
        if(num >= 1000){
            sb.append('M');
            sb.append(intToRoman(num-1000));
        }else if(num >= 900){
            sb.append("CM");
            sb.append(intToRoman(num-900));
        }else if(num < 900 && num >= 500){
            sb.append("D");
            sb.append(intToRoman(num - 500));
        }else if(num < 500 && num >= 400){
            sb.append("CD");
            sb.append(intToRoman(num - 400));
        }else if(num >= 100 && num < 400){
            sb.append("C");
            sb.append(intToRoman(num - 100));
        }else if(num < 100 && num >= 90){
            sb.append("XC");
            sb.append(intToRoman(num - 90));
        }else if(num < 90 && num >= 50){
            sb.append("L");
            sb.append(intToRoman(num - 50));
        }else if(num < 50 && num >= 40){
            sb.append("XL");
            sb.append(intToRoman(num - 40));
        }else if(num < 40 && num >= 10){
            sb.append("X");
            sb.append(intToRoman(num - 10));
        }else if(num == 9){
            sb.append("IX");
        }else if(num >= 5 && num < 9){
            sb.append("V");
            sb.append(intToRoman(num - 5));
        }else if(num == 4){
            sb.append("IV");
        }else if(num < 4){
            sb.append("I");
            sb.append(intToRoman(num - 1));
        }
        return sb.toString();
    }
}
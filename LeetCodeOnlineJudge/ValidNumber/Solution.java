//Validate if a given string is numeric.
//
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
public class Solution{
    public boolean isNumber(String s) {
        if(s.length() == 0) return false;
        int len = s.length();
        int start = 0;
        int end = len;
        while(start < end && s.charAt(start) == ' '){
            start++;
        }
        while(start < end && s.charAt(end - 1) == ' '){
            end--;
        }
        if(start >= end) return false; 
        String a = s.substring(start, end);
        if(checkInteger(a)) return true;
        if(checkFloat(a)) return true;
        if(checkSci(a)) return true;
        return false;
    }
    public boolean checkInteger(String s){
        if(s.length() == 0) return false;
        int len = s.length();
        int start = 0;
        boolean digit = false;
        for(int i = start; i < len; i++){
            if(i == start && (s.charAt(i) == '-' || s.charAt(i) == '+')) continue;
            if(Character.isDigit(s.charAt(i))){
                digit = true;
                continue;
            }
            return false;
        }
        return digit;
    }
    public boolean checkFloat(String s){
        if(s.length() == 0) return false;
        int len = s.length();
        int start = 0;
        boolean dot = false;
        boolean digit = false;
        for(int i = start; i < len; i++){
            if(i == start && (s.charAt(i) == '-' || s.charAt(i) == '+')) continue;
            if(s.charAt(i) == '.' && dot == false){
                dot = true;
                continue;
            }
            if(Character.isDigit(s.charAt(i)) == true){
                digit = true;
                continue;
            }
            return false;
        }
        return digit;
    }
    public boolean checkSci(String s){
        if(s.length() == 0) return false;
        int len = s.length();
        int start = 0;
        int e = -1;
        boolean digit = false;
        boolean dot = false;
        for(int i = start; i < len; i++){
            if(i == e + 1 && (s.charAt(i) == '-' ||s.charAt(i) == '+')) continue;
            if(Character.isDigit(s.charAt(i))){
                digit = true;
                continue;
            }
            if(s.charAt(i) == '.' && e == -1 && dot == false){
                dot = true;
                continue;
            }
            if(s.charAt(i) == 'e' && e == -1 && digit == true){
                e = i;
                digit = false;
                continue;
            }
            return false;
        }
        return digit;

    }
    public static void main(String args[]){
        Solution sol = new Solution();
        String s = "1.";
        System.out.println(sol.isNumber(s));
    }
}

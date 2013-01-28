//Implement atoi to convert a string to an integer.
//
//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
//
//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 
public class Solution{
    public int atoi(String str) {
        if(str == null || str.length() == 0) return 0; 
        boolean neg = false;
        int start = 0;
        int len = str.length();
        while(start < len && str.charAt(start) == ' '){
            start++;
        }
        if(str.charAt(start) == '-'){
            neg = true;
            start = start + 1;
        }else if(str.charAt(start) == '+'){
            neg = false;
            start = start + 1;
        }
        
        while(start < len && !Character.isDigit(str.charAt(start))){
            return 0;
        }

        long ans = 0;
        for(int i = start; i < len; i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                int e = Character.getNumericValue(c);
                ans = ans * 10 + e;
            }else{
                break;
            }
        }
        if(neg) ans = -ans; 
        if(ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
        if(ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
        return (int)ans;
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}


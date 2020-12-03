class Solution2 {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int i = 0;
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if(i == n) return 0;
        boolean isNegative = false;

        if(s.charAt(i) == '+'){
            i++;
        }else if(s.charAt(i) == '-'){
            isNegative = true;
            i++;
        }
        int num = 0;
        while(i < n && Character.isDigit(s.charAt(i))){
            int c = Character.getNumericValue(s.charAt(i));
            int newNum = num * 10 + c;

            if((newNum - c)/10 != num || (newNum < 0)){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = newNum;
            i++;
        }

        if(isNegative){
            return -num;
        }else{
            return num;
        }

    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.myAtoi("2147483648"));
    }
}
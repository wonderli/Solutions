class Solution {
    public int maxPower(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        int len = s.length();
        if(len == 1) return 1;
        int i = 0;
        int j = 1;
        int count = 0;
        int max = 0;
        while(j < len){
            if(s.charAt(j) ==s.charAt(i)){
                count++;
                max = Math.max(count, max);
            }else{
                i = j;
                count = 1;
            }
            j++;
        }
        return Math.max(max, j - i);
        
    }
}
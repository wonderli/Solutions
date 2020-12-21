class Solution {
    public int balancedStringSplit(String s) {
        if(s.length() == 0) return 0;
        int countL = 0;
        int countR = 0;
        int result = 0;
        for(char c : s.toCharArray()){
            if(c == 'L') {
                countL++;
            }else{
                countR++;
            }
            if(countL == countR){
                result++;
                countL = 0;
                countR = 0;
            }
        }
        return result;
    }
}
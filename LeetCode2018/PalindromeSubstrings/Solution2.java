class Solution2 {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int result = 0;
        for(int i = 0; i < n; i++){
            result += expand(s, i, i);
            result += expand(s, i, i+1);
        }
        return result; 
    }
    private int expand(String s, int i, int j){
        int n = s.length();
        int result = 0;
        while(i >= 0 && j < n){
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
            result++;
            i--;
            j++;
        }
        return result;
    }
}
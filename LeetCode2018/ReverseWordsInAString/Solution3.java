class Solution3 {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        reverse(cs, 0, n-1);
        int len = 0;
        for(int i = 0; i < n; i++){
            if(cs[i] == ' '){
                continue;
            }
            if(len > 0){
                cs[len] = ' ';
                len++;
            }
            int tmp = len;
            while(i < n && cs[i] != ' '){
                cs[len] = cs[i];
                i++;
                len++;
            }
            i--;
            reverse(cs, tmp, len - 1);
        }
        return new String(cs, 0, len);
    }
    private void reverse(char[] cs, int i, int j){
        while(i < j){
            char tmp = cs[i];
            cs[i] =cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }
}
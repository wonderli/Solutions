import java.util.*;
class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n-1);
        int len = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == ' '){
                continue;
            }
            int j = i;
            while(j < n && s[j] != ' '){
                j++;
            }
            reverse(s, i, j-1);
            i = j;
        }
    }
    private void reverse(char[] s, int i, int j){
        while(i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
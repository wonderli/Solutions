#include <iostream>
#include <string>
int lengthOfLongestSubstring(string s){
    int n = s.length();
    int i = 0; 
    int j = 0;
    bool exist[256] = {false};
    int maxLen = 0;
    while(j < n){
        if(exist[s[j]]){
            maxLen = max(maxLen, j - i);
            while(s[i] != s[j]){
                exist[s[i]] = false;
                i++;
            }
            i++;
            j++;
        } else {
            exist[s[i]] = true;
            j++;
        }
    }

    maxLen = max(maxLen, n-i);
    return maxLen;
}
int main(){
}

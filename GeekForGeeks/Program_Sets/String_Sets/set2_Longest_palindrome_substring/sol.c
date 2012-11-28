#include <stdio.h>
#include <string.h>
void printPalindromeSubstring(char *s, int start, int end){
    int i = 0;
    for(i = start; i <= end; i++){
        printf("%c", s[i]);
    }
    printf("\n");
}
int longestPalindromeSubstring(char *s){
    int max = 0;
    int i = 0;
    int len = strlen(s);
    int low = 0;
    int high = 0;
    int start = 0;
    for(i = 0; i < len; i++){
        low = i - 1;
        high = i;
        while(low >= 0 && high < len && s[low] == s[high]){
            if(high - low + 1 > max){
                start = low;
                max = high - low + 1;
            }
            low--;
            high++;
        }
        low = i - 1;
        high = i + 1;
        while(low >= 0 && high < len && s[low] == s[high]){
            if(high - low + 1 > max){
                start = low;
                max = high - low + 1;
            }
            low--;
            high++;
        }
    }
    printf("Longest Palindrome Substring:\n");
    printPalindromeSubstring(s, start, start + max - 1);
    return max;
}
int main(){
    char s[] = "forgeeksskeegfor";
    printf("Length %d\n", longestPalindromeSubstring(s));
}

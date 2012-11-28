#include <stdio.h>
#include <string.h>
void printSubstring(char *s, int begin, int end){
    int i = 0;
    for(i = begin; i <=end; i++){
        printf("%c", s[i]);
    }
}
int longestPalindromeSubstring(char *s){
    int n = strlen(s);
    int table[n][n];
    memset(table, 0 ,sizeof(table));
    int max = 1;
    int i = 0;
    for(i = 0; i < n; i++){
        table[i][i] = 1;
    }
    int begin = 0;
    for(i = 0; i < n - 1; i++){
        if(s[i] == s[i+1]){
            table[i][i+1] = 1;
            begin = i;
            max = 2;
        }
    }
    int k = 0;
    int j = 0;
    for(k = 3; k <= n; k++){
        for(i = 0; i < n - k + 1; i++){
            j = i + k - 1;
            if(table[i+1][j-1] == 1 && s[i] == s[j]){
                table[i][j] = 1;
                if(k > max){
                    begin = i;
                    max = k;
                }
            }
        }
    }
    printf("Longest Palindrome SsubString: ");
    printSubstring(s, begin, begin + max - 1);
    return max;
}
int main(){
    char s[] = "forgeeksskeegfor";
    printf("\nLength: %d\n", longestPalindromeSubstring(s));
    return 0;
}

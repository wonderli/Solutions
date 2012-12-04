#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void computeLPSArray(char *pattern, int M, int *next){
    int len = 0;
    int i;
    next[0] = 0;
    i = 1;
    while(i < M){
        if(pattern[i] == pattern[len]){
            len++;
            next[i] = len;
            i++;
        }else{
            if(len != 0){
                len = next[len - 1];
            }else{
                next[i] = 0;
                i++;
            }
        }
    }
}
void KMPsearch(char *pattern, char *txt){
    int M = strlen(pattern);
    int N = strlen(txt);
    int *next = (int *)malloc(sizeof(int) * M);
    int j = 0;
    computeLPSArray(pattern, M, next);
    int i = 0;
    while(i < N){
        if(pattern[j] == txt[i]){
            i++;
            j++;
        }
        if(j == M){
            printf("Found pattern at index %d \n", i-j);
            j = next[j-1];
        }
        else if(pattern[j] != txt[i]){
            if(j != 0){
                j = next[j-1];
            }else{
                i = i+1;
            }
        }
    }
    free(next);

}
int main(){
    char txt[] = "AABAACAADAABAAABAA";
    char pattern[] = "AABA";
    KMPsearch(pattern, txt);
    return 0;
}

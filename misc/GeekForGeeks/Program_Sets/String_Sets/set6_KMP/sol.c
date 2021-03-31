#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void printArray(int *array, int M){
    int i = 0;
    for(i = 0; i < M; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
}
void computeLPSArray(char *pattern, int M, int *next){
    int len = 0;
    int i;
    next[0] = 0;
    i = 1;
    while(i < M){
        //printf("Len %d\n", len);
        if(pattern[i] == pattern[len]){
            len++;
            next[i] = len;
            i++;
        }else{
            if(len != 0){
                //printf("%d, %d, %d\n", i, len, next[len -1]);
                len = next[len - 1];
            }else{
                next[i] = 0;
                i++;
            }
        }
    }
        printArray(next,M);
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
//    char txt[] = "ABABDABACDABABCABAB";
    //char pattern[] = "ABABCABAB";
//    char txt[] = "nananano";
//    char pattern[] = "nano";
    printf("TXT: %s\n", txt);
    printf("Pattern: %s\n", pattern);
    
    KMPsearch(pattern, txt);
//    int M = strlen(pattern);
//    int *next = (int *)malloc(sizeof(int) * M);
//    computeLPSArray(pattern, M, next);
//    int i = 0;
//    for(i = 0; i < M; i++){
//        printf("%c ", pattern[i]);
//    }
//    printf("\n");
//
//    for(i = 0; i < M; i++){
//        printf("%d ", next[i]);
//    }
//    printf("\n");
//    free(next);
    return 0;
}
/*
 * n a n a n a n o
 * n a n o
 *
 *
 */


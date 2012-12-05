#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void printArray(int array[], int len){
    int i = 0;
    for(i = 0; i < len; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
}
void getNext(char p[], int next[]){
    int i = 0;
    int j = -1;
    int len = strlen(p);
    next[0] = -1;
    while(i < len){
        if(j == -1 || p[i] == p[j]){
            i++;
            j++;
            if(p[i] != p[j]){
                next[i] = j;
            }else{
                next[i] = next[j];
            }
        }else{
            j = next[j];
        }
    }
}
int kmp(char s[], char p[], int pos, int next[]){
    int i = pos - 1;
    int j = -1;
    int slen = strlen(s);
    int plen = strlen(p);
    while(i < slen && j < plen){
        if(j == -1 || s[i] == p[j]){
            i++;
            j++;
        }else{
            j = next[j];
        }
    }
    if(j >= plen) return i - plen;
    else return -1;
}
int main(){
    char s[] = "abababc";
    char p[] = "ababc";
    int M = strlen(p);
    int next[M];
    getNext(p, next);
    printArray(next, M);
    int r = kmp(s, p, 0, next);
    printf("%d \n", r);

}

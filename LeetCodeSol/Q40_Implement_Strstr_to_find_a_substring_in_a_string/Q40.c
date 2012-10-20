#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char* strstr2(char *text, char *word){
    if(!*word) return text;
    while(*text){
        char *w = word;
        char *begin = text;
        while(*text && *w && *text == *w){
            text++;
            w++;
        }
        if(!*w) return begin;
        text = begin + 1;
    }
    return NULL;
}
int main(){
    char *word = (char *)malloc(1024);
    char *word2 = (char *)malloc(1024);
    char *text = (char *)malloc(1024);
    char *text2 = (char *)malloc(1024);
//    strcpy(text, "abcd");
//    strcpy(word, "ab");
//    printf("Result: %s\n", strstr2(text, word));
    strcpy(text, "ABC ABCDAB ABCDABCDABDE");
    strcpy(text2, "ABC ABCDAB ABCD");
    strcpy(word, "ABCDABD");
    strcpy(word2, "ABC");
    printf("Result: %s\n",strstr2(text, word));
    printf("Result: %s\n",strstr2(text, word2));
    printf("Result: %s\n",strstr2(text2, word));
    printf("Result: %s\n",strstr2(text2, word2));
    return 0;
}

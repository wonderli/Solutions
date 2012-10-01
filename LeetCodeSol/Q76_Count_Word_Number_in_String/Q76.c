//count words in string
//The key is word count number increase when NOTINWORD turn to INWORD status.
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
int count_word(char *s) {
    if(s == NULL){
        printf("Empty string\n");
        return 0;
    }
    int wc = 0;
    int in_word = FALSE;
    char *ptr = s;
    while(*ptr != '\0'){
        if(isalpha(*ptr) && !in_word){
            in_word = TRUE;
            wc++;
        }else if(in_word && *ptr == ' '){
            in_word = FALSE;
        }
        ptr++;
    }
    return wc;
}
int main(){
    int size = 1024;
    char *s = (char *)malloc(size);
    strcpy(s, "helloword,       helloword");

    printf("%s\n", s);
    printf("%d\n", count_word(s));
    return 0;

}

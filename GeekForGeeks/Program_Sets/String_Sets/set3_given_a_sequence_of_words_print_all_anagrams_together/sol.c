#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct word{
    char *s;
    int index;
} Word;
typedef struct array{
    Word *w;
    int size;
} Array;
Array *createArray(char *str[], int size){
    Array *a = (Array *)malloc(sizeof(Array));
    a->w = (Word *)malloc(sizeof(Word) * size);
    a->size = size;
    int i = 0; 
    for(i = 0; i < size; i++){
        a->w[i].index = i;
        a->w[i].s = (char *)malloc(strlen(str[i]) + 1);
        strcpy(a->w[i].s, str[i]);
    }
    return a;
}
int cmpChar(const void *a, const void *b){
    return *(char *)a - *(char *)b;
}
int cmpStr(const void *a, const void *b){
    Word *tmp1 = (Word *)a;
    Word *tmp2 = (Word *)b;
    return strcmp(tmp1->s, tmp2->s);
}
void printAnagramsTogether(char *str[], int size){
    Array *a = createArray(str, size);
    int i = 0;
    for(i = 0; i < size; i++){
        qsort(a->w[i].s, strlen(a->w[i].s), sizeof(char), cmpChar);
    }
    qsort(a->w, size, sizeof(a->w[0]), cmpStr);
    for(i = 0; i < size; i++){
        printf("%s ", str[a->w[i].index]);
    }
}
int main(){
    char *str[] = {"cat", "dog", "tac", "god", "act"};
    int size = sizeof(str)/sizeof(str[0]);
    printAnagramsTogether(str, size);
    return 0;

}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void reverseWord(char *s, int start, int end){
    if(!s){
        printf("\nError\n");
        return;
    }
    int i = start;
    int j = end;
    char temp;
    while(i < j){
        temp = *(s+i);
        *(s + i) = *(s + j);
        *(s + j) = temp;
        i++;
        j--;
    }

}
void reverseSentence(char *s){
    int len = strlen(s);
    reverseWord(s, 0, len-1);
    printf("%s\n", s);
    int start = 0;
    int end = 0;
    while(end < len - 1){
        if(*(s + end) == ' '){
            reverseWord(s, start, end-1);
            end++;
            start = end;
        }else{
            end++;
        }
    }
}
int main(){
    //char *s = (char *)malloc(1024);
    //strcpy(s, "I am a student");
    char s[] = "I am a student.";
    printf("%s\n", s);
    reverseSentence(s);
    printf("%s\n", s);

}

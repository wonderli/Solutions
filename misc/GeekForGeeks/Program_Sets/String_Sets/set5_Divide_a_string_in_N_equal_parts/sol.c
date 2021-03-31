#include <stdio.h>
#include <string.h>
void printStr(char *s, int start, int n){
    int i = 0;
    for(i = start; i < start + n; i++){
        printf("%c", s[i]);
    }
    printf("\n");
}
void split(char *s,int n){
    int len = strlen(s);
    if(len%n != 0){
        printf("Can't divided\n");
        return ;
    }
    int t = len/n;
    int i = 0;
    for(i = 0; i < len;){
        printStr(s, i, t);
        i = i + t;
    }

}
int main(){
    char *s = "a_simple_divide_string_quest";
    split(s, 4);
    return 0;
}

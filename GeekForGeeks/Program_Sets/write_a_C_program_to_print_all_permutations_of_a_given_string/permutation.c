#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void swap(char *x, char *y){
    char tmp = *x;
    *x = *y;
    *y = tmp;
}

void permutation(char *s, int begin, int end){
    int range = end - begin;
    int i = 0;
    if(range == 0){
        printf("%s\n", s);
        return ;
    }
    else{
        for(i = begin; i < end; i++){
            swap(s+i, s+begin);
            permutation(s, begin+1, end);
            swap(s+i, s+begin);
        }
    }
}

int main(){
    char *s = (char *)malloc(1024);
    strcpy(s, "ABCD");
    permutation(s, 0, 4);

}

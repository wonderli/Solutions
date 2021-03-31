#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int compare(const void *a, const void *b){
    return *(char *)a - *(char *)b;
}
void swap(char *a, char *b){
    char tmp = *a;
    *a = *b;
    *b = tmp;
}
//void getPermutation(char str[], int begin, int end){
//    int range = end - begin;
//    int i = 0;
//    if(range == 0){
//        printf("%s\n", str);
//    }else {
//        for(i = 0; i < range; i++){
//            swap(&str[i], &str[begin+i]);
//            getPermutation(str, begin+1, end);
//            swap(&str[i], &str[begin+i]);
//        }
//    }
//    
//
//}
int findCeil(char str[], char first, int l, int h){
    int ceilIndex = l;
    int i = 0;
    for(i = l+1; i <= h; i++){
        if(str[i] > first && str[i] < str[ceilIndex]){
            ceilIndex = i;
        }
    }
    return ceilIndex;
}
void sortedPermutations(char str[]){
    int size = strlen(str);
    qsort(str, size, sizeof(str[0]), compare);
    int isFinished = 0;
    while(!isFinished){
        printf("%s\n", str);
        int i;
        for(i = size - 2; i >= 0; --i){
            if(str[i] < str[i+1])
                break;
        }
        if(i == -1) isFinished = 1;
        else {
            int ceilIndex = findCeil(str, str[i], i+1, size - 1);
            swap(&str[i], &str[ceilIndex]);
            qsort(str + i + 1, size - i - 1, sizeof(str[0]), compare);
        }
    }
}
int main(){
    char str[] = "ABCD";
    //getPermutation(str, 0, strlen(str));
    sortedPermutations(str);
    //printf("%s\n", str);
}


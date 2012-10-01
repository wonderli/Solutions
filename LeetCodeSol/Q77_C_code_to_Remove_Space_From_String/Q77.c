//Write a C function to remove spaces from a string. The function header should be void removeSpaces(char *str)
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void removeSpaces(char *str){
    char *ptr1 = str;//Slow pointer
    char *ptr2 = str;//Fast pointer
    do{
        while(*ptr2 == ' '){
            ptr2++;
        }
        *ptr1++ = *ptr2++;
        }while(*ptr2 != '\0');
    *ptr1 = '\0';
    //}while(*ptr1 != '\0');
    //}while(*ptr1++ = *ptr2++);
}
int main(){
    int size = 1024;
    char *s = (char *)malloc(size);
    strcpy(s, "how are you?");
    printf("Before: %s\n",s);
    removeSpaces(s);
    printf("After: %s\n", s);
    return 0;
}


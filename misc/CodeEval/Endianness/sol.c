#include <stdio.h>
int main(int argc, char *argv[]){
    int a = 1;
    char *s = (char *)&a;
    if( *s == 0x0001){
        printf("LittleEndian");
    }else{
        printf("BigEndian");
    }
}

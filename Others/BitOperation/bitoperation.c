//coming from bit twiddle, for myself easy understooding.
#include <stdio.h>
#define CHAR_BIT 8
//Compute the integer variable abs value without braching
void printBinary(int v){
    int sz = sizeof(int) * 8;
    char s[sz]; 
    int i = 0;
    int x = v;
    for(i = sz - 1; i >= 0; i--){
        s[i] = (x & 1) ? '1' : '0';
        x = x >>1;
    }
    printf("%d\tbinary format\t", v);
    for(i = 0; i < sz; i++){
        printf("%c", s[i]);
        if((i+1)%8 == 0) printf(" ");
    }
    printf("\n");
}
void getAbs(int v){
    unsigned int r;
    int const mask = v >> sizeof(int) * CHAR_BIT - 1;
    r = (v + mask) ^ mask;
    printBinary(v);
    printBinary(mask);
    printBinary(v + mask);
    printBinary(r);
}
int main(){
    int v = -10;
    getAbs(v);
}

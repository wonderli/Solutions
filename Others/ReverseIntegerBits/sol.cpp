#include <stdio.h>
void printBits(int x){
    printf("\n-----------------\n");
    int count = 0;
    int space = 0;
    while(count < 32){
        if(space%4 == 0){
            printf(" ");
        }
        printf("%d",x&1);
        x = x >> 1;
        count++;
        space++;
    }
    printf("\n-----------------\n");
}
int countBits(int x){
    x = (x & 0x55555555) + ((x & 0xaaaaaaaa) >> 1);
    x = (x & 0x33333333) + ((x & 0xcccccccc) >> 2);
    x = (x & 0x0f0f0f0f) + ((x & 0xf0f0f0f0) >> 4);
    x = (x & 0x00ff00ff) + ((x & 0xff00ff00) >> 8);
    x = (x & 0x0000ffff) + ((x & 0xffff0000) >> 16);
    printf("\nBits number is %d\n", x);
}
int main(){

    int x = 345678;
    countBits(x);
    printBits(x);
    x = ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
    printBits(x);
    x = ((x & 0xcccccccc) >> 2) | ((x & 0x33333333) << 2);
    printBits(x);
    x = ((x & 0xf0f0f0f0) >> 4) | ((x & 0x0f0f0f0f) << 4);
    printBits(x);
    x = ((x & 0xff00ff00) >> 8) | ((x & 0x00ff00ff) << 8);
    printBits(x);
    x = ((x & 0xffff0000) >> 16) | ((x & 0x0000ffff) << 16);
    printBits(x);
}

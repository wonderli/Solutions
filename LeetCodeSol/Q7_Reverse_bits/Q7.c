#include <stdio.h>
void printBinary(int num){
    int size = sizeof(num) * 8;
    int i = 0;
    for(i = size - 1; i >= 0; i--){
        printf("%d", ((num >> i) & 1));
    }
    printf("\n");
}
unsigned int swapBit(unsigned int num, unsigned int i, unsigned int j){
    unsigned int low = ((num >> i) & 1);
    unsigned int high = ((num >> j) & 1);
    //printf("Low %ud High %ud\n", low, high);
    if(low ^ high){
        num ^= ((1U << i) | (1U << j));
    }
    return num;
}

unsigned int reverse(unsigned int num){
    unsigned int size = sizeof(num) * 8;
    unsigned int i = 0;
    for(i = 0; i < size/2; i++){
        num = swapBit(num, i, size - 1 - i);
    }
    return num;
}

int main(){
    unsigned int num = 0;
    scanf("%ud", &num);
    printBinary(num);
    unsigned int newNum = reverse(num);
    printBinary(newNum);
}

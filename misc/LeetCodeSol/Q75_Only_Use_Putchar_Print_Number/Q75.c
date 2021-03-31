#include <stdio.h>
void putlong(unsigned long n){
    if(n <= 10){
        putchar(n + '0');
        return;
    }
    if(n > 0)
    {
        putlong(n/10);
        putchar(n%10 + '0');
    }
}
int main(){
    unsigned long num = 65536;
    putlong(num);
}

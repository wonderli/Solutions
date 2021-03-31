#include <stdio.h>
float mySquare(float x){
    int i = 0;
    int time = 8;
    float guess = 2;
    while(i < time){
        guess = (guess + x/guess)/2;
        i++;
    }
    printf("%lf", guess);
}
int main(){
    float x = 2;
    mySquare(2);
}

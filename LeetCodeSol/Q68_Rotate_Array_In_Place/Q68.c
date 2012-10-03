//Rotate array in space
#include <stdio.h>
#include <stdlib.h>
void rotate_array(char array[], int n, int k){
    int step = 0;
    while(step < k){
        int index = 0;
        char tmp = array[index];
        while(index < n) {
            char tmp2 = array[(index + 1)%n];
            array[(index + 1)%n] = tmp;
            tmp = tmp2;
            index++;
        }
        step++;
    }
}
void print_array(char array[], int n){
    printf("\n---------------------------\n");
    int i = 0;
    for(i = 0; i < n; i++){
        printf("%c ", array[i]);
    }
    printf("\n---------------------------\n");
}
int main(){
    int n = 7;
    char array[n];
    int k = 3;
    int i = 0;
    for(i = 0; i < n; i++) {
        array[i] = 'a' + i;
    }
    print_array(array, n);
    rotate_array(array, n, k);
    print_array(array, n);

    return 0;
}

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
void reverse_str(char *s, int start, int end){
    char *p1 = s + start;
    char *p2 = s + end;
    while(p1 < p2){
        char tmp = *p1;
        *p1 = *p2;
        *p2 = tmp;
        p1++;
        p2--;
    }
}
void rotate_str(char *s, int n, int k){
    reverse_str(s, 0, n - 1);
    reverse_str(s, 0, k - 1);
    reverse_str(s, k, n - 1);
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
    //rotate_str(array, n, k);
    print_array(array, n);

    return 0;
}

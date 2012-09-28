#include <stdio.h>
int find_greatest_sum(int array[], int len){
    int i = 0;
    int great_sum = 0;
    int current_sum = 0;
    for(i = 0; i < len; i++) {
        current_sum += array[i];
        if(current_sum < 0)
            current_sum = 0;
        if(current_sum > great_sum)
            great_sum = current_sum;
    }
    if(great_sum == 0){
        great_sum = array[0];
        for(i = 1; i < len; i++) {
            if(great_sum < array[i])
                great_sum = array[i];
        }
    }
    return great_sum;
}
int main(){
    int array[] = {1, -2, 3, 10, -4, 7, 2, -5};
    int len = 8;
    printf("\n sum: %d\n", find_greatest_sum(array, len));
    return 0;
}

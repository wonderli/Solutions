#include <stdio.h>
#define MIN_VALUE -9999
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
typedef struct result{
    int start;
    int end;
    int sum;
} res;

res find_greatest_sum_with_memory(int array[], int len) {
    res r;

    int start = 0;
    int tmp_start = 0;
    int end = 0;

    int cur_sum = 0;
    int great_sum = MIN_VALUE;

    int i = 0;
    for(i = 0; i < len; i++){
        cur_sum += array[i];
        if(cur_sum < 0){
            cur_sum = 0;
            tmp_start = i + 1;
        }
        if(great_sum < cur_sum) {
            great_sum = cur_sum;
            start = tmp_start;
            end = i;
        }
    }
    r.start = start;
    r.end = end;
    r.sum = great_sum;
    
    return r;
}
int check_neg(int array[], int len){
    int flag = 1;
    int i = 0;
    for(i = 0; i < len; i++) {
        if(array[i] > 0)
            return 0;
    }
    return 1;
}
res find_largest(int array[], int len){
    res r;
    int sum = array[0];
    int i = 0;
    for(i = 1; i < len; i++){
        if(sum < array[i]){
            sum = array[i];
            r.start = i;
            r.end = i;
            r.sum = sum;
        }
    }
    return r;
}
int main(){
    //int array[] = {1, -2, 3, 10, -4, 7, 2, -5};
    int array[] = {-8, -1, -3, -10, -4, -7, -2, -5};
    //int array[] = {-8, -1, -3, 10, -4, -7, -2, -5};
    int len = 8;
    res r;
    if(!check_neg(array, len)){
        r = find_greatest_sum_with_memory(array, len);
    }else {
        r = find_largest(array, len);
    }
    printf("start: %d\n", r.start);
    printf("end: %d\n", r.end);
    printf("sum: %d\n", r.sum);
    int i = 0;
    printf("The sequence : ");
    for(i = r.start; i <= r.end; i++){
        printf("%d ", array[i]);
    }
    printf("\n");
    return 0;
}

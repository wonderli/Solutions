#include <stdio.h>
void printArray(int array[], int n){
    int i = 0;
    while(i < n){
        printf("%d ", array[i]);
        i++;
    }
    printf("\n");
}
int compare(void const *a, void const *b){
    return *(int *)a - *(int *)b;
}
int findSum(int array[], int n, int sum){
    //printArray(array, n);
    qsort(array, n, sizeof(array[0]), compare);
    //printArray(array, n);
    int i = 0;
    int j = n - 1;
    int curr = 0;
    while(i < j){
        curr = array[i] + array[j];
        if(curr > sum){
            j--;
        }else if(curr < sum){
            i++;
        }else if(curr == sum){
            break;
        }
    }
    if(curr == sum){
        printf("find it %d + %d = %d\n", array[i], array[j], sum);
    }else{
        printf("Couldn't found it\n");
    }
}
int main(){
    int array[] = {40, 10, 100, 90, 20, 25};
    int size = sizeof(array)/sizeof(array[0]);
    int sum = 65;
    findSum(array, size, sum);

}

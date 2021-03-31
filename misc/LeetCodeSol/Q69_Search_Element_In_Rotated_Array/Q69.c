#include <stdio.h>
#include <stdlib.h>
int rotate_binary_search(int array[], int key, int begin, int end){
    int mid = (begin + end)/2;
    if(array[mid] == key) return mid;
    if(array[begin] <= array[mid]){
        if(key >= array[begin] && key < array[mid]){
            return rotate_binary_search(array, key, begin, mid - 1);
        }else{
            return rotate_binary_search(array, key, mid + 1, end);
        }
    } else {
        if(key > array[mid] && key <= array[end]){
            return rotate_binary_search(array, key, mid + 1, end);
        }
        else {
            return rotate_binary_search(array, key, begin, mid - 1);
        }
    }
    return -1;
}
int main(){
    //int array[] = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
    int array[] = {6, 8, 1, 2, 4, 5};
    int key = 8;
    int ret = rotate_binary_search(array, key, 0, 5);
    printf("ret: %d\n", ret);
    return 0;

}

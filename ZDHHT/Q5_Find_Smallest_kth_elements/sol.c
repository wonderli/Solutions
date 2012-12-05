#include <stdio.h>
void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}
void maxHeap(int heap[], int i, int len){
    int largeIndex = -1;
    int left = i * 2;
    int right = i * 2 + 1;
    if(left <= len && heap[left] > heap[i]){
        largeIndex = left;
    }else{
        largeIndex = i;
    }
    if(right <= len && heap[right] > heap[largeIndex]){
        largeIndex = right;
    }
    if(largeIndex != i){
        swap(&heap[i], &heap[largeIndex]);
        maxHeap(heap, largeIndex, len);
    }
}
void buildHeap(int heap[], int len){
    if(heap == NULL) return;
    int index = len/2;
    int i = 0;
    for(i = index; i >= 1; i--){
        maxHeap(heap, i, len);
    }
}
int main(){
    int k = 5;
    int len = 10;
    int array[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int heap[k+1];
    heap[0] = 0;
    int i = 0; 
    for(i = 1; i < k + 1; i++){
        heap[i] = array[i-1];
    }
    for(i = 0; i <= k; i++){
        printf("%d ", heap[i]);
    }
    printf("\n");

    for(i = k; i < len; i++){
        if(array[i] < heap[1]){
            heap[1] = array[i];
            maxHeap(heap, 1, k);
        }
    }
    for(i = 0; i <= k; i++){
        printf("%d ", heap[i]);
    }
    printf("\n");




}

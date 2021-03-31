#include <stdio.h>
#include <stdlib.h>
void merge(int a[], int b[], int last_a, int last_b) {
    int index_a = last_a - 1;
    int index_b = last_b - 1;
    int index = last_a + last_b - 1;
    while(index_a >= 0 && index_b >= 0) {
            if(a[index_a] > b[index_b]){
                a[index] = a[index_a];
                index--;
                index_a--;
            }
            else{
                a[index] = b[index_b];
                index--;
                index_b--;
            }
    }
    while(index_b >= 0) {
        a[index] = b[index_b];
        index--;
        index_b--;
    }
}
void print_array(int array[], int size){
    int i = 0;
    printf("\n*****************************\n");
    for(i = 0; i < size; i++) {
        printf("%d ", array[i]);
    }
    printf("\n*****************************\n");
}
int compare(const void *a, const void *b) {
    if (*(int *)a > *(int *)b) 
        return 1;
    else
    return -1;
}
int main() {
    int size = 20;
    int a[size];
    int b[size/2];
    int i = 0;
    srand(rand()%10);
    for(i = 0; i < size; i++) {
        a[i] = rand()%10 + 1;
    }
    qsort(a, size, sizeof(int), compare);
    for(i = 0; i < size/2; i++) {
        b[i] = rand()%10;
        a[i + 10] = 0;
    }
    qsort(b, size/2, sizeof(int), compare);
    print_array(a, size);
    print_array(b, size/2);
    merge(a, b, size/2, size/2);
    print_array(a, size);
}

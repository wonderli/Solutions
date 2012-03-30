#include <stdio.h>
#include <stdlib.h>
#define SIZE 10
void setZero(int matrix[][SIZE], int size) {
    int i, j;
    int row[size];
    int col[size];
    for(i = 0; i < size; i++) {
        row[i] = 0;
        col[i] = 0;
    }
    for(i = 0; i < size; i++) {
        for(j = 0; j < size; j++) {
            if(matrix[i][j] == 0) {
                row[i] = 1;
                col[j] = 1;
            }
        }
    }
    for(i = 0; i < size; i++) {
        for(j = 0; j < size; j++) {
            if(row[i]||col[j]) matrix[i][j] = 0;
        }
    }
}
void printMatrix(int matrix[][SIZE], int size) {
    int i, j;
    printf("\n*******************************\n");
    for(i = 0; i < size; i++) {
        for(j = 0; j < size; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
    printf("\n*******************************\n");
}
int main() {
    int i, j;
    int size;
    size = SIZE;
    int matrix[size][size];
    for(i = 0; i < size; i++) {
        for(j = 0; j < size; j++) {
            matrix[i][j] = rand()%9;
        }
    }
    printMatrix(matrix, size);
    setZero(matrix, size);
    printMatrix(matrix, size);
    return 0;

}

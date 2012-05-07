#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void rotate_matrix(int **matrix, int n)
{
    int layer;
    int i, j;
    for(layer = 0; layer < n/2; layer++) {
        int first = layer;
        int last = n - 1 - layer;
        for(i = first; i < last; i++) {
            int offset = i - first;
            //Store top
            int top = *(*(matrix + i) + first);
            //Store left to top
            *(*(matrix + i) + first) = *(*(matrix + first) + last - offset);
            //Store bottom to left
            *(*(matrix + first) + last - offset) = *(*(matrix + last - offset) + last);
            //Store right to bottom
            *(*(matrix + last - offset) + last) = *(*(matrix + last ) + i);
            //Store top to right
            *(*(matrix + last) + i) = top;
        }
    }
}
int main()
{
    int **matrix;
    int N = 4;
    matrix = (int **)malloc(N* sizeof(int*));
    int i = 0;
    int j = 0;
    for(i = 0; i < N; i++)
    {
        *(matrix+i) = (int *)malloc(N * sizeof(int));

    }

    int count = 0;
    for(i = 0; i < N; i++) {
        for(j = 0; j < N; j++) {
            *(*(matrix + j) + i) = count;
            count++;
        }
    }
    printf("\n*************************\n");
    printf("\nOriginal Matrix:\n");
    for(i = 0; i < N; i++) {
        for(j = 0; j < N; j++) {
            printf("%d\t", *(*(matrix + j) + i));
        }
        printf("\n");
    }
    printf("\nNew Matrix:\n");
    rotate_matrix(matrix, N);
    for(i = 0; i < N; i++) {
        for(j = 0; j < N; j++) {
            printf("%d\t", *(*(matrix + j) + i));
        }
        printf("\n");
    }
    printf("\n*************************\n");
    return 0;
}

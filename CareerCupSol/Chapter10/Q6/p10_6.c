#include <stdio.h>
#include <stdlib.h>
typedef struct RESULT{
	int row;
	int col;
} result;
int M = 5;
int N = 5;

void search(int **matrix, int key, int first_row, int last_row, int first_col, int last_col, result *r){
    if(first_row > M - 1  || last_col < 0)
    {
        perror("Did not find the value you want");
        return;
    }
    int v = *(*(matrix + last_col) + first_row);
    if(v == key) {
        r->row = first_row;
        r->col = last_col;
        return;
    }
    else if(v > key){
        first_row++;
        search(matrix, key, first_row, last_row, first_col, last_col, r);
    }
    else if(v < key) {
        last_col--;
        search(matrix, key, first_row, last_row, first_col, last_col, r);
    }

    		
}

void print_matrix(int **matrix, int M, int N) {
	int row, col;
	printf("\n***************************************************************************************************\n");
	for(row = 0; row < M; row++) {
		for(col = 0; col < N; col++) {
			printf("%5d ", *(*(matrix + col) + row));
		}
		printf("\n");
	}
	printf("\n***************************************************************************************************\n");
}
int main(){
	int **matrix = (int **)malloc(1024);
	int i = 0;
	for(i = 0; i < 1024; i++) {
		*(matrix + i) = (int *) malloc(1024);
	}
	int row, col;
	i = 0;
	for(row = 0; row < M; row++) {
		for(col = 0; col < N; col++) {
			*(*(matrix + col) + row) = M*N - i;
			i++;
		}
	}
	print_matrix(matrix, M, N);
    int key;
    while(scanf("%d", &key) != EOF) {
        int first_row = 0;
        int last_row = N - 1;
        int first_col = 0;
        int last_col = M - 1;
        result *r = (result *)malloc(sizeof(struct RESULT));
        r->row = -1;
        r->col = -1;
        printf("\nSEARCHING KEY: %d\n", key);
        search(matrix, key, first_row, last_row, first_col, last_col, r);
        printf("\nROW: %d, COL: %d\n", r->row, r->col);
    }
}

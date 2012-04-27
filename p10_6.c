#include <stdio.h>
#include <stdlib.h>
typedef struct RESULT{
	int row;
	int col;
} result;

void search(int **matrix, int key, int first_row, int last_row, int first_col, int last_col, result *r){
	int mid_row, mid_col;
	mid_row = (first_row + last_row)/2;
	mid_col = (first_col + last_col)/2;
	if(*(*(matrix + mid_col) + mid_row) == key){
		r->row = mid_row;
		r->col = mid_col;
		return;
	}
	if(*(*(matrix + mid_col) + mid_row) > key) {
		search(matrix, key, mid_row + 1, last_row, mid_col + 1, last_col, r);
	}else if(*(*(matrix + mid_col) + mid_row) < key) {
		search(matrix, key, first_row, mid_row, first_col, mid_col, r);
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
	int M = 20;
	int N = 20;
	int row, col;
	i = 0;
	for(row = 0; row < M; row++) {
		for(col = 0; col < N; col++) {
			*(*(matrix + col) + row) = i;
			i++;
		}
	}
	print_matrix(matrix, M, N);
	int key = 5;
	int first_row = 0;
	int last_row = N;
	int first_col = 0;
	int last_col = M;
	result *r = (result *)malloc(sizeof(struct RESULT));
	r->row = 0;
	r->col = 0;
 	search(matrix, key, first_row, last_row, first_col, last_col, r);
	printf("ROW: %d, COL: %d", r->row, r->col);
}

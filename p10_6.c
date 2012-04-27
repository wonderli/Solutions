#include <stdio.h>
#include <stdlib.h>
typedef struct RESULT{
	int row;
	int col;
} result;

void search(int **matrix, int key, int first_row, int last_row, int first_col, int last_col, result *r){
	int matrix_first_row_first_col = *(*(matrix + first_col) + first_row);
	int matrix_first_row_last_col = *(*(matrix + last_col) + first_row);
	int matrix_last_row_first_col = *(*(matrix + first_col) + last_row);
	int matrix_last_row_last_col = *(*(matrix + last_col) + last_row);
	if(matrix_first_row_first_col < key && matrix_first_row_last_col < key && matrix_last_row_first_col > key && matrix_last_row_last_col > key){
		int mid_row = (first_row + last_row)/2;
		int mid_col = (first_col + last_col)/2;
		if(*(*(matrix + mid_col) + mid_row) == key){
			r->row = mid_row;
			r->col = mid_col;
			return;
		}
		if(*(*(matrix + mid_col) + mid_row) > key) {
			search(matrix, key, first_row, mid_row - 1, first_col, mid_col - 1, r);
		}else if(*(*(matrix + mid_col) + mid_row) < key) {
			search(matrix, key, mid_row, last_row, mid_col, last_col, r);
		}
	}
	else if(matrix_first_row_first_col <= key && matrix_first_row_last_col >= key)
	{
		int mid_col = (first_col + last_col)/2;
		if(*(*(matrix + mid_col) + first_row) == key){
			r->row = first_row;
			r->col = mid_col;
			return;
		}

		if(*(*(matrix + mid_col) + first_row) > key) {
			search(matrix, key, first_row, first_row, first_col, mid_col - 1, r);
		}else if(*(*(matrix + mid_col) + first_row) < key) {
			search(matrix, key, first_row, last_row, mid_col, last_col, r);
		}
		
	}
	else if(matrix_last_row_first_col <= key && matrix_last_row_last_col >= key)
	{
		int mid_col = (first_col + last_col)/2;
		if(*(*(matrix + mid_col) + last_row) == key){
			r->row = last_row;
			r->col = mid_col;
			return;
		}

		if(*(*(matrix + mid_col) + last_row) > key) {
			search(matrix, key, last_row, last_row, first_col, mid_col - 1, r);
		}else if(*(*(matrix + mid_col) + first_row) < key) {
			search(matrix, key, last_row, last_row, mid_col, last_col, r);
		}

	}

	else {
		r->row = -1;
		r->col = -1;
		printf("\nDid not find the key %d\n", key);
		return;
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
	int key = 25;
	int first_row = 0;
	int last_row = N - 1;
	int first_col = 0;
	int last_col = M - 1;
	result *r = (result *)malloc(sizeof(struct RESULT));
	r->row = -1;
	r->col = -1;
 	search(matrix, key, first_row, last_row, first_col, last_col, r);
	printf("\nROW: %d, COL: %d\n", r->row, r->col);
}

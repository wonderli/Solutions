#include <stdio.h>
#include <stdlib.h>
void merge(int array[], int size, int left, int mid, int right) {
	int current, left_index, right_index, i;
	int helper[size];
	for(i = left; i <= right; i++){
		helper[i] = array[i];
	}
	current = left;
	left_index = left;
	right_index = mid + 1;
	while(left_index <= mid && right_index <= right) {
		if(helper[left_index] <= helper[right_index]) {
			array[current] = helper[left_index];
			left_index++;
		}
		else {
			array[current] = helper[right_index];
			right_index++;
		}
		current++;
	}
	
	int remain = mid - left_index;
	for(i = 0; i <= remain; i++)
		array[current + i] = helper[left_index + i];

}
void merge_sort(int array[], int size, int left, int right ) {
	int mid;
	if(left < right) {
		mid = (left + right)/2;
		merge_sort(array, size, left, mid);
		merge_sort(array, size, mid + 1, right);
		merge(array, size, left, mid, right);
	}
}
void print_array(int array[], int size) {
	printf("\n*********************\n");
	int i = 0;
	for(i = 0; i < size; i++) {
		if(i == (size - 1)) {
			printf("%d", array[i]);
		}
		else
		printf("%d->", array[i]);
	}
	printf("\n*********************\n");
}
int main() {
	int size = 20;
	int array[size];
	int i = 0;
	for(i = 0; i< size; i++) {
		array[i] = size - i;
	}
	print_array(array, size);
	merge_sort(array, size, 0, size - 1);
	print_array(array, size);



}

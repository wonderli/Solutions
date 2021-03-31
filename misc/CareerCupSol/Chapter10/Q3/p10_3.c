#include <stdio.h>
#include <stdlib.h>
int search(int a[], int left, int right, int key) {
    int mid = (left + right)/2;
    if(a[mid] == key) {
        return mid;
    }
    if(left > right)
        return -1;
    if(a[left] < a[mid]) {
        if(a[left] <= key && key <= a[mid]) {
            return search(a, left, mid, key);
        }
        else 
            return search(a, mid + 1, right, key);
    }
    else if(a[mid] < a[right]) {
        if(a[mid] <= key && key <= a[left]) {
            return search(a, mid, right, key);
        }
        else
            return search(a, left, mid - 1, key);

    } 
    else if(a[left] == a[mid]) {
        if(a[mid] != a[right]) {
            return search(a, mid + 1, right, key);
        }
        else {
            int ret = search(a, left, mid - 1, key);
            if(ret == -1) {
                return search(a, mid + 1, right, key);
            }
            else
                return ret;
        }
    }
    return -1;
}

int main() {
    int a[12] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
    int ret = search(a, 0, 11, 5);
    printf("\n%d\n",ret);

}

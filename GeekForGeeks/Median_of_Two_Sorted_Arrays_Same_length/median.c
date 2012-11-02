#include <stdio.h>
int max(int, int);
int min(int, int);
int median(int [], int);
int getMedian(int a[], int b[], int n){
    if(n <= 0) return -1;
    if(n == 1) return (a[0] + b[0])/2;
    if(n == 2) return (max(a[0], b[0]) + min(a[1], b[1]))/2;
    int m1 = median(a, n);
    int m2 = median(b, n);
    if(m1 == m2) return m1;
    if(m1 < m2) {
        if(n%2 == 0) return getMedian(a+n/2-1, b, n-n/2+1);
        else return getMedian(a+n/2, b, n-n/2);
    }else {
        if(n%2 == 0) return getMedian(b+n/2-1, a, n-n/2+1);
        else return getMedian(b+n/2, a, n-n/2);
    }
}
int median(int a[], int n){
    if(n%2 == 0) return (a[n/2] + a[n/2 - 1])/2;
    else return a[n/2];
}
int max(int a, int b){
    return a > b ? a : b;
}
int min(int a, int b){
    return a < b ? a : b;
}
int main(){
    //int a[] = {1, 3, 5, 7, 9};
    int a[] = {1, 3, 7, 15, 22};
    int b[] = {2, 14, 16, 18, 100};
    printf("%d\n", getMedian(a, b, 5));

}

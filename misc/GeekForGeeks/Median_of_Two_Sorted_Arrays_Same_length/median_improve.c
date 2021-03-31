#include <stdio.h>
int getMedian(int a[], int b[], int n){
    return getMedianRec(a, b, 0, n-1, n);
}
int getMedianRec(int a[], int b[], int left, int right, int n){
    int i, j;
    if(left > right)
        return getMedianRec(b, a, 0, n-1, n);
    i = (left + right)/2;
    j = n - i - 1;
    if(b[j] < a[i] && (j == n-1 || a[i] <= b[j+1])){
        if(i == 0 || b[j] > a[i-1]) 
            return (a[i] + b[j])/2;
        else return (a[i] + a[i-1])/2;
    }
    else if(a[i] > b[j] &&  j != n-1 && a[i] > b[j+1]){
        return getMedianRec(a, b, left, i-1, n);
    }
    else return getMedianRec(a, b, i+1, right, n);
}
int main(){
    int a[] = {1,3,5,7,9};
    int b[] = {2,4,6,8,10};
    int size = sizeof(a)/sizeof(a[0]);
    printf("%d\n", getMedian(a, b, size));
    return 0;
}

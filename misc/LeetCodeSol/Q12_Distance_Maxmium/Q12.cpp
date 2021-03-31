#include <iostream>
using namespace std;
int findMaxDistanceBF(int array[], int n){
    int max = -1;
    for(int i = 0; i < n; i++){
        for(int j = 1; j < n; j++){
            if(array[j] > array[i] && max < (j - i)){
                max = j - i;
            }
        }
    }
    return max;
}
int max(int x, int y){
    return x > y ? x : y;
}
int min(int x, int y){
    return x < y ? x : y;
}
int findMaxDistance(int array[], int n){
    int maxDiff = -1;
    int i, j;
    int Lmin[n];
    int Rmax[n];
    Lmin[0] = array[0];
    for(i = 1; i < n; i++){
        Lmin[i] = min(array[i], Lmin[i-1]);
    }
    Rmax[n-1] = array[n-1];
    for(j = n-2; j >= 0; j--){
        Rmax[j] = max(array[j], Rmax[j+1]);
    }
    i = 0;
    j = 0;
    while(j < n && i < n){
        if(Lmin[i] < Rmax[j]){
            maxDiff = max(maxDiff, j - i);
            j++;
        }
        else{
            i++;
        }
    }
    return maxDiff;
}
int main(){
    int array[] = {34,26,26,32,33,24,5,23,12,23};
    int n = sizeof(array)/sizeof(array[0]);
    cout << "size: " << n << endl;
    cout << "max diff: " << findMaxDistanceBF(array, n) << endl;
    cout << "max diff: " << findMaxDistance(array, n) << endl;

}


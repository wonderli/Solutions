//given an unsorted array, find the first missing integer
#include <iostream>
#include <algorithm>
using namespace std;
int find(int array[], int n){
    int ret = 0;
    for(int i = 0; i < n; i++){
        if(array[i] == i+ 1) continue;
        while(array[i] >= 1 && array[i] <= n && array[i] != i + 1 && array[array[i] - 1] != array[i]){
            swap(array[array[i]-1], array[i]);
        }
    }
    for(int i = 0; i < n; i++){
        if(array[i] != i+1) {
            ret = i;
            break;
        }
    }
    for(int i = 0; i < n; i++){
        cout << array[i] << endl;
    }
    return ret;

}
int main(){
    int array[] = {3, -1, 4, 1};
    cout << find(array, sizeof(array)/sizeof(array[0])) << endl;
}

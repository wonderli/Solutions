#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <bitset>
#include <cstdio>
#include <vector>
#include <cstdlib>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
using namespace std;
/* Head ends here */
void quickSort(vector<int> &ar, int l, int r){
    if(l >= r) return;
    int pivot = ar[l];
    vector<int> large;
    vector<int> small;
    for(int i = l; i <= r; i++){
        if(ar[i] < pivot){
            small.push_back(ar[i]);
        }else{
            large.push_back(ar[i]);
        }
    }
    //small.push_back(ar[l]);
    int m = small.size() + l;
    small.insert(small.end(), large.begin(), large.end());
    for(int i = l; i <= r; i++){
        ar[i] = small[i - l];
    }
    quickSort(ar, l, m-1);
    quickSort(ar, m+1, r);
    for(int i = l; i <= r; i++){
        cout << ar[i];
        if(i+1 <= r) cout << " ";
        else cout << endl;
    }
}
void quickSort(vector <int>  &ar, int ar_size) {
    quickSort(ar, 0, ar_size-1);
}
/* Tail starts here */
int main() {
    vector <int>  _ar;
    int _ar_size;
    cin >> _ar_size;
    for(int _ar_i=0; _ar_i<_ar_size; _ar_i++) {
        int _ar_tmp;
        cin >> _ar_tmp;
        _ar.push_back(_ar_tmp); 
    }
    quickSort(_ar, _ar_size);
    return 0;
}

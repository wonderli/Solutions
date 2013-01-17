#include <iostream>
#include <vector>
using namespace std;
void permute(int num[], int begin, int end, int n){
    int range = end - begin;
    if(range == 0){
        for(int i = 0; i < n; i++){
            cout << num[i] << " ";
        }
        cout << endl;
    }
    for(int i = 0; i < range; i++){
        swap(num[begin], num[begin + i]);
        permute(num, begin + 1, end, n);
        swap(num[begin], num[begin + i]);
    }

}
int main(){
    int num[] = {1, 2, 3};
    int len = sizeof(num)/sizeof(num[0]);
    permute(num, 0, len, len);
}



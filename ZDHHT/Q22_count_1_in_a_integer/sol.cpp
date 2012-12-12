#include <iostream>
using namespace std;
int findOnes(int n){
    int count = 0;
    while(n!=0){
        n = n & (n - 1);
        count++;
    }
    return count;
}
int main(){
    int n = 0;
    cin >> n;
    cout << findOnes(n) << endl;

}

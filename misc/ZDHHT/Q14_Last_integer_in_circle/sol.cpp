#include <iostream>
using namespace std;
int f(int n, int m){
    if(n < 1||m < 1) return -1;
    if(n == 1) return 0;
    else if(n > 1){
        return (f(n-1, m) + m)%n;
    }
}
int main(){
    int n = 100;
    cout << f(n,5) << endl;
}

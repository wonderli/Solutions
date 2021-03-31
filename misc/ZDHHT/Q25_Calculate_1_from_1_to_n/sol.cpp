#include <iostream>
using namespace std;
int f(int n){
    int number = 0;
    while(n != 0){
        if(n % 10 == 1){
            number++;
        }
        n /= 10;
    }
    return number;
}
int calculate(int n){
    int number = 0;
    for(int i = 0; i <= n; i++){
        number += f(i);
    }
    return number;
}
int main(){
    int i = 0;
    cin >> i;
    cout << calculate(i) << endl;
}

#include <iostream>
using namespace std;
void printContinuousSequence(int small, int big){
    for(int i = small; i <= big; i++){
        cout << i << " ";
    }
    cout << endl;
}
void findSequence(int n){
    if(n < 3) return;
    int small = 1;
    int big = 2;
    int mid = (1 + n)/2;
    int sum = small + big;
    while(small < mid){
        if(sum == n){
            printContinuousSequence(small, big);
        }
        while(sum > n){
            sum -= small;
            small++;
            if(sum == n){
                printContinuousSequence(small, big);
            }
        }
        big++;
        sum += big;
    }
    
}

int main(){
    int num = 0;
    while(cin >> num){
        cout << "RESULT" << endl;
        findSequence(num);
        cout << "PLEASE ENTER: ";
    }
}

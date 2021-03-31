#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#include <cstring>
#include <fstream>
#include <cmath>
#define p(x) std::cout << #x << ": " << x << std::endl
using namespace std;
bool checkPalindrome(int val){
    int ten = 1;
    while(val/ten > 10){
        ten *=10;
    }
    while(val > 0){
        int a = val/ten;
        int b = val%10;
        if(a != b) return false;
        val = (val % ten)/10;
        ten = ten/100;
    }
    return true;
}
bool checkPrime(int val){
    int i = 2;
    while(i <= sqrt(val)){
        if(val%i == 0) return false;
        i++;
    }
    return true;
}
int main(int argc, char* argv[]){
    int val = 1000;
    while(val >= 2){
        if(checkPrime(val) && checkPalindrome(val)) break;
        val--;
    }
    cout << val << endl;
}

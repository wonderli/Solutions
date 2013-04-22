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
bool checkPrime(int val){
    int i = 2;
    while(i <= sqrt(val)){
        if(val%i == 0) return false;
        i++;
    }
    return true;
}
int main(int argc, char* argv[]){
    int count = 0;
    int val = 2;
    int sum = 0;
    while(count < 1000){
        while(checkPrime(val)){
            count++;
            sum += val;
            val++;
        }
        val++;
    }
    cout << sum << endl;
}

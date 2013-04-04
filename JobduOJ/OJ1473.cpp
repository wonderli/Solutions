#include <iostream>
#include <vector>
#include <string>
#define p(x) std::cout << #x << ": " << x << std::endl;
using namespace std;
string solve(int num){
    if(num == 0) return string("0");
    string s;
    while(num >0){
        s = ((num & 1) == 1 ? '1' : '0') + s;
        num = num >> 1;
    }
    return s;
}
int main(){
    int n = 0;
    cin >> n;
    vector<string> v(n);
    for(int i = 0; i < n; i++){
        unsigned int num = 0;
        cin >> num;
        v[i] = solve(num);
    }
    for(int i = 0; i < n; i++){
        cout << v[i] << endl;
    }
}

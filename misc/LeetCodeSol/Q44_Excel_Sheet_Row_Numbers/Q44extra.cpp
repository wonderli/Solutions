#include <iostream>
#include <string>
using namespace std;
string num2string(int num){
    //string str(1, 'a' + num%26);
    //num = num / 26;
    string str;
    while(num != 0){
        str = (char)('a' + (num - 1) % 26) + str;
        num = num /26;
    }
    return str;
}
int main(){
    int num = 27;
    cout << num2string(num) << endl;
}


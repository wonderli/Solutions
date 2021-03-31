#include <iostream>
#include <string>
using namespace std;
string num2string(int num){
    string str(1, 'a' + num%26);
    num = num / 26;
    while(num != 0){
        str = (char)('a' + (num - 1) % 26) + str;
        num = num /26;
    }
    return str;
}
void num2string_recur(int num){
    if(num == 0) return;
    num2string_recur(num / 26);
    cout << (char)('a' + (num - 1)%26);
}
void num2str(int num){
    num2string_recur(num /26);
    cout << (char)('a' + num%26) << endl;
}
int main(){
    int num = 727;
    cout << num2string(num) << endl;
    cout << "*********" << endl;
    num2str(num);
}


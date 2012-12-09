#include <iostream>
#include <string>
using namespace std;
int strToint(string str){
    char *s = const_cast<char *>(str.c_str());
    int len = str.length();
    int num = 0;
    int start = 0;
    int negflag = 0;
    if(s[0] == '-' || s[0] == '+'){
        start = 1;
        negflag = 1;
    }
    for(int i = start; i < len; i++){
        num *= 10;
        num += (s[i] - '0');
    }
    if(negflag == 1){
        num *= -1;
    }
    return num;
}
int main(){
    string s;
    cout << "Enter num string" << endl;
    cin >> s;
    int len = s.length();
    int num = strToint(s);
    cout << "Number " << num << endl;

}

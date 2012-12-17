#include <iostream>
using namespace std;
int reverse(int i){
    int num = 0;
    while(i != 0){
        num = num * 10 + i%10;
        i = i/10;
    }
    return num;
}
void reverseString(char s[]){
    int len = strlen(s);
    int i = 0;
    int j = len - 1;
    char c;
    while(i < j){
        c = s[i];
        s[i] = s[j];
        s[j] = c;
        i++;
        j--;
    }
}

void myitoa(int num, char s[]){
    int start = 0;
    if(num < 0){
        s[start] = '-';
        start++;
        num *= -1;
    }
    while(num != 0){
        s[start] = num % 10 + '0';
        num = num/10;
        start++;
    }
    s[start] = '\0';
    reverseString(s);
}
int myatoi(char *str){
    if(str == NULL) return 0;
    int start = 0;
    bool isNeg = false;
    if(str[0] == '-'){
        start++;
        isNeg = true;
    }
    int end = strlen(str) - 1;
    int num = 0;
    while(start <= end){
        num = num * 10 + (str[start] - '0');
        start++;
    }
    if(isNeg) num *= -1;
    return num;
}
int myadd(int x, int y){
    int carry = 0;
    while(y != 0){
        carry = x & y;
        x = x ^ y;
        y = carry << 1;
    }
    return x;
}
int mymultiply(int x, int y){
    int ret = 0;
    while(y!=0){
        if(y&1){
            ret = ret + x;
        }
        x <<= 1;
        y >>= 1;
    }
    return ret;
}
int mysubstract(int x, int y){
    y = ~y + 1;
    return x + y;
}
int main(){
//    int i = 0;
//    cin >> i;
//    cout << reverse(i) << endl;
//    char s[100];
//    myitoa(i, s);
//    cout << s << endl;
//    char str[] = "-1123456789";
//    cout << str << endl;
//    cout << myatoi(str) << endl;
    int x = 0;
    int y = 0;
    cin >> x >> y;
//    cout << myadd(x,y) << endl;
//    cout << mymultiply(x,y) << endl;
    cout << mysubstract(x, y) << endl;
}

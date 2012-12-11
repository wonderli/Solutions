#include <iostream>
#include <cstring>
using namespace std;
void reverse(char *s, int start, int end){
    if(s == NULL) return ;
    int i = start;
    int j = end - 1;
    while(i < j){
        char temp = *(s+i);
        *(s+i) = *(s+j);
        *(s+j) = temp;
        i++;
        j--;
    }
}
void rotateString(char *s, int m){
    if(s == NULL || m > strlen(s)){
        return ;
    }
    int len = strlen(s);
    reverse(s, 0, m);
    //cout << s << endl;
    reverse(s, m, len);
    //cout << s << endl;
    reverse(s, 0, len);
    //cout << s << endl;
}
int main(){
    char s[] = "abcdefg";
    int m = 3;
    cout << s << endl;
    rotateString(s, m);
    cout << s << endl;

}

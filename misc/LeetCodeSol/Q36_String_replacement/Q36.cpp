//The core part is use two pointer one is slow and another is fast, then everything solved perfectly.
#include <iostream>
using namespace std;
bool isMatch(char *str, const char *pattern){
    while(*pattern){
        if(*str != *pattern) {
            return false;
        }
        str++;
        pattern++;
    }
    return true;
}
void replace(char *str, const char *pattern){
    if(str == NULL || pattern == NULL) return;
    char *slow = str;
    char *fast = str;
    int p_len = strlen(pattern);
    while(*fast != '\0'){
        bool matched = false;
        if(isMatch(fast, pattern)){
            matched = true;
            fast += p_len;
        }
        if(matched == true){
            *slow = 'X';
            slow++;
        }
        if(*fast != '\0'){
            *slow = *fast;
            slow++;
            fast++;
        }
    }
    *slow = '\0';
}
int main(int argc, char *argv[]){
    char *str = (char*)malloc(1024);
    const char *pattern = "abc";
    strcpy(str, "abcdeffdfegabcab");
    replace(str, pattern);
    cout << str << endl;
    
}

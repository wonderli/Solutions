#include <iostream>
using namespace std;
void deleteString(char *str, char *d){
    int tablesize = 256;
    int hashTable[tablesize];
    memset(hashTable, 0, sizeof(hashTable));
    while(*d != '\0'){
        hashTable[*d] = 1;
        d++;
    }
    char *pSlow = str;
    char *pFast = str;
    while(*pFast != '\0'){
        if(hashTable[*pFast] != 1){
            *pSlow = *pFast;
            pSlow++;
        }
        pFast++;
    }
    *pSlow = '\0';
}
int main(){
    char str[] = "helloworld";
    char d[] = "aeiou";
    cout << str << endl;
    deleteString(str, d);
    cout << str << endl;
}

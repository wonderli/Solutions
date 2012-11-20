#include <iostream>
#include <algorithm>
#include <stdlib.h>
#include <cstring>
using namespace std;
int permutation(char *set, int begin, int end){
    int range = end - begin;
    if(range == 0){
        cout << set << endl;
        return 0;
    }else{
        for(int i = 0; i < range; i++){
            swap(set[begin], set[i]);
            permutation(set, begin+1, end);
            swap(set[begin], set[i]);//reset
        }
    }
    return 0;
}

int main(){
    char *set = (char *)malloc(1024);
    strcpy(set, "1234");
    cout << set << endl;
    permutation(set, 0, strlen(set));
}

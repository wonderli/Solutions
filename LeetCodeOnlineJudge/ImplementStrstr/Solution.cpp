//Implement strStr().
//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
#include <iostream>
using namespace std;
class Solution{
    char *strStr(char *haystack, char *needle) {
        if(*haystack == *needle && *needle == '\0') return haystack;
        for(int i = 0; haystack[i] != '\0'; i++){
            int j = 0;
            bool match = true;
            for(; needle[j] != '\0'; j++){
               if(haystack[i+j] == '\0') break;
               if(haystack[i+j] != needle[j]){
                   match = false;
                   break;
               }
            }
            if(match && needle[j] == '\0') return haystack + i;
            if(haystack[i+j] == '\0') break;
        }
        return NULL;
    }
};
int main(int argc, char* argv[]){
}

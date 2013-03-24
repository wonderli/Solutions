#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution{
    public:
        bool checkInteger(const char *s, int l, int r){
            bool digit = false;
            for(int i = l; i < r; i++){
                if(i == l && (s[i] == '-'|| s[i] == '+')) continue;
                if(isdigit(s[i])) {
                    digit = true;
                    continue;
                }
                return false;
            }
            return digit;
        }
        bool checkFloat(const char *s, int l, int r){
            bool dot = false;
            bool digit = false;
            for(int i = l; i < r; i++){
                if(i == l && (s[i] == '-' || s[i] == '+')) continue;
                if(isdigit(s[i])){
                    digit = true;
                    continue;
                }
                if(s[i] == '.' && !dot){
                    dot = true;
                    continue;
                }
                return false;
            }
            return digit;
        }
        bool checkSci(const char *s, int l, int r){
            bool digit = false;
            bool dot = false;
            int e = l - 1;
            for(int i = l; i < r; i++){
                if(i == e + 1 && (s[i] == '-'||s[i] == '+')) continue;
                if(isdigit(s[i])) {digit = true; continue;};
                if(s[i] == '.' && e == l - 1 && !dot) {dot = true; continue;};
                if(s[i] == 'e' && e == l - 1 && digit){
                    e = i;
                    digit = false;
                    continue;
                }
                return false;
            }
            return digit;
        }
        bool isNumber(const char *s) {
            if(s == NULL || *s == '\0') return false;
            int i = 0;
            int j = strlen(s);
            while(i < j && s[i] == ' ') i++;
            while(i < j && s[j-1] == ' ') j--;
            if(checkInteger(s,i,j)) return true;
            if(checkFloat(s, i, j)) return true;
            if(checkSci(s, i, j)) return true; 
            return false;
        }

};
int main(int argc, char* argv[]){
    Solution sol;
    char *s = "2.3.";
    cout << sol.checkSci(s, 0, 4);
}

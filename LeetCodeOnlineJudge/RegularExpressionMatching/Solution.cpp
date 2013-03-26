#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#define p(x) std::cout << #x << ": " << x << std::endl;
using namespace std;
class Solution{
    public:
        bool isMatch(const char *s, const char *p) {
            int sLen = strlen(s);
            int pLen = strlen(p);
            if(pLen == 0) return sLen == 0;
            if(pLen == 1 || p[1] != '*'){
                if(sLen < 1 || (p[0] != '.' && p[0] != s[0])){
                    return false;
                }
                return isMatch(s+1, p+1);
            }else{
                int i = -1;
                while((i < sLen) && (i < 0 || p[0] == '.' || p[0] == s[i])){
                    if(isMatch(s+i+1, p+2))
                        return true;
                    i++;

                }
                return false;

            }

        }


};
int main(int argc, char* argv[]){
}

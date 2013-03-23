//Implement atoi to convert a string to an integer.
#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;
class Solution{
    public:
        int atoi(const char *str) {
            if(str == NULL) return 0;
            int i = 0;
            while(str[i] != '\0' && str[i] == ' ') i++;
            bool neg = false;
            if(str[i] == '-') neg =true;
            if(str[i] == '+' || str[i] == '-'){
                i++;
            }
            long long ret = 0;
            while(str[i] != '\0'){
                if(str[i] >= '0' && str[i] <= '9'){
                    ret = ret * 10 + str[i] - '0';
                }else break;
                i++;
            }
            if(neg) ret = -ret;
            if(ret > INT_MAX) return INT_MAX;
            if(ret < INT_MIN) return INT_MIN;
            return ret;
        }


};
int main(int argc, char* argv[]){
    char *str = "123";
    Solution sol;
    cout << sol.atoi(str);
}

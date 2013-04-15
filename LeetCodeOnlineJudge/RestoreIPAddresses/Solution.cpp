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
        vector<string> restoreIpAddresses(string s) {
            vector<string> ret;
            int len = s.length();
            if(len < 4 || len > 12) return ret;
            int i = 0;
            for(int j = i + 1; j < len; j++){
                for(int k = j + 1; k < len; k++){
                    for(int l = k + 1; l < len; l++){
                        string a = s.substr(i, j - i);
                        string b = s.substr(j, k - j);
                        string c = s.substr(k, l - k);
                        string d = s.substr(l);
                        if(check(a, b, c, d)){
                            ret.push_back(a + "." + b + "." + c + "." + d);
                        }
                    }
                }
            }
            return ret;
        }
        bool check(string a, string b, string c, string d){
            bool lencheck = (a.length() < 4) && (b.length() < 4) && (c.length() < 4) && (d.length() < 4);
            if(lencheck == false) return false;
            bool zerocheck = (a.length() == 1 || a[0] != '0') && (b.length() == 1||b[0] != '0') && (c.length() == 1 || c[0] != '0') && (d.length() == 1 || d[0] != '0');
            if(zerocheck == false) return false;
            int aValue = atoi(a.c_str());
            int bValue = atoi(b.c_str());
            int cValue = atoi(c.c_str());
            int dValue = atoi(d.c_str());
            bool valueCheck = (aValue >= 0 && aValue <= 255) && (bValue >= 0 && bValue <= 255) && (cValue >= 0 && cValue <= 255) && (dValue >= 0 && dValue <= 255);
            return valueCheck;
        }
        

};
int main(int argc, char* argv[]){
}

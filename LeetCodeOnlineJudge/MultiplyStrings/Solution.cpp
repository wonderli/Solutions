#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
using namespace std;
#define p(x) std::cout << #x << ": " << x << std::endl;
class Solution{
    public:
        string add(string a, string b){
            if(a.length() == 0) return b;
            if(b.length() == 0) return a;
            if(a.size() < b.size()){
                swap(a, b);
            }
            int aLen = a.size();
            int bLen = b.size();
            int i = aLen - 1;
            int j = bLen - 1;
            int carry = 0;
            string s;
            while(i >= 0){
                int x = a[i] - '0';
                int y = (j >=0)? b[j]-'0' : 0;
                int r = (x + y + carry) %10;
                carry = (x + y + carry)/10;
                char c = r + '0';
                s = c + s;
                i--;
                j--;
            }
            if(carry > 0){
                char c = carry + '0';
                s = c + s;
            }
            return s;
        }
        string multiply(string num, char a){
            if(a == '0') return "0";
            int x = a - '0';
            string s;
            int n = num.length();
            int carry = 0;
            for(int i = n - 1; i >= 0; i--){
                int y = num[i] - '0';
                int r = (x * y + carry)%10;
                carry = (x * y + carry)/10;
                char c = r + '0';
                s = c + s;
            }
            if(carry > 0){
                char c = carry + '0';
                s = c + s;
            }
            return s;
        }
        string multiply(string num1, string num2) {
            if(num1.length() == 0 || num2.length() == 0) return 0;
            if(num1.length() < num2.length()){
                swap(num1, num2);
            }
            int n = num2.length();
            string ret;
            for(int i = n-1; i >= 0; i--){
                string r = multiply(num1, num2[i]);
                for(int j = 0; j < n -1- i; j++){
                    r = r + "0";
                }
                ret = add(ret, r);
            }
            return ret;
        }
        


};
int main(int argc, char* argv[]){
    Solution sol;
    cout << sol.add("99", "2") << endl;
    cout << sol.multiply("999999", "1002") << endl;
}

#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;
class Solution{
    public:
        string addBinary(string a, string b) {
            if(a.length() == 0) return b;
            if(b.length() == 0) return a;
            if(a.length() < b.length()) swap(a, b);
            string ret = "";
            int n = a.length();
            int m = b.length();
            int c = 0;
            for(int i = n-1, j = m-1; i >= 0; i--, j--){
                int l = a[i] - '0';
                int r = (j >= 0) ? b[j] - '0':0;
                int x = (l + r + c)%2;
                c = (l + r + c)/2;
                ret = ((x == 1) ? "1" : "0") + ret;
            }
            if(c == 1){
                ret = "1" + ret;
            }
            return ret;
        }


};
int main(int argc, char* argv[]){
    string a("101");
    string b("1");
    Solution sol;
    cout << sol.addBinary(a, b);
}

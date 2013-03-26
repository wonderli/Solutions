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
        bool checkAllstars(const char *p){
            int n = strlen(p);
            for(int i = 0; i < n; i++){
                if(p[i] != '*') return false;
            }
            return true;
        }
        //bool isMatch(const char *s, const char *p) {
        //    int sLen = strlen(s);
        //    int pLen = strlen(p);
        //    if(pLen == 0) return sLen == 0;
        //    if(sLen == 0) return  pLen == 0 || checkAllstars(p);
        //    if(s[0] == p[0] || p[0] == '?'){
        //        return isMatch(s + 1, p + 1);
        //    }
        //    if(p[0] == '*'){
        //        return isMatch(s+1, p) || isMatch(s, p+1);
        //    }
        //    return false;

        //}
        bool check(char a, char b){
            return a == b || b == '?';
        }
        bool isMatch(const char *s, const char *p){
            int sLen = strlen(s);
            int pLen = strlen(p);
            if(pLen == 0) return sLen == 0;
            if(sLen > 3000) return false;
            vector< vector<bool> > dp(sLen+1, vector<bool>(pLen+1, false));
            dp[0][0] = true;
            for(int i = 0; i <= sLen; i++){
                for(int j = 0; j <= pLen; j++){
                    if(i > 0){
                        dp[i][j] = dp[i-1][j] && p[j-1] == '*';
                    }
                    if(j > 0){
                        dp[i][j] = dp[i][j] || dp[i][j-1] && p[j-1] == '*';
                    }
                    if(i > 0 && j > 0){
                        dp[i][j] = dp[i][j] || dp[i-1][j-1] && check(s[i-1], p[j-1]);
                    }
                }
            }
            return dp[sLen][pLen];


        }


};
int main(int argc, char* argv[]){
    Solution sol;
    cout << sol.isMatch("a", "aa");
}

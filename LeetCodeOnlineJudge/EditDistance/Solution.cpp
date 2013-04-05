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
        int minDistance(string word1, string word2) {
            int m = word1.length();
            int n = word2.length();
            if(m == 0) return n;
            if(n == 0) return m;
            vector< vector<int> > dp(m + 1, vector<int>(n + 1, 0));
            for(int i = 0; i <= m; i++){
                dp[i][0] = i;
            }
            for(int j = 0; j <= n; j++){
                dp[0][j] = j;
            }
            int cost = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(word1[i-1] == word2[j-1]){
                        cost = 0;
                    }else{
                        cost = 1;
                    }
                    dp[i][j] = min(min(dp[i][j-1] + 1, dp[i-1][j] + 1), dp[i-1][j-1] + cost);
                }
            }
            return dp[m][n];

        }


};
int main(int argc, char* argv[]){
}

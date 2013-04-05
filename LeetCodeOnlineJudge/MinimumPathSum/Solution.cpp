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
        int minPathSum(vector<vector<int> > &grid) {
            int m = grid.size();
            int n = grid[0].size();
            vector< vector<int> > dp(m, vector<int>(n, 0));
            dp[0][0] = grid[0][0];
            for(int i = 1; i < m; i++){
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
            for(int j = 1; j < n; j++){
                dp[0][j] = dp[0][j-1] + grid[0][j];
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                        dp[i][j] = min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
                }
            }
            return dp[m-1][n-1];
        }


};
int main(int argc, char* argv[]){
    vector<int> v(1);
    v[0] = 0;
    vector< vector<int> > vv;
    vv.push_back(v);
    Solution sol;
    sol.minPathSum(vv);
}

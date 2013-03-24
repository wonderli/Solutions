#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution{
    public:
        int numDecodings(string s) {
            if(s.length() == 0) return 0;
            int n = s.length();
            vector<int> dp(n+1, 0);
            dp[0] = 1;
            for(int i = 1; i <= n; i++){
                if(s[i-1] >= '1') dp[i] += dp[i-1];
                if(i > 1){
                    int num = (s[i-2] - '0') * 10 + (s[i-1] - '0');
                    if(num >= 10 && num <= 26){
                        dp[i] = dp[i] + dp[i-2];
                    }
                }
            }
            return dp[n];
        }



};
int main(int argc, char* argv[]){
}

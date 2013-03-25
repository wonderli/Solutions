#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
using namespace std;
class Solution{
    public:
        vector<string> generateParenthesis(int n) {
            vector<string> ret;
            string s = "";
            helper(n, n, s, ret);
            return ret;
        }
        void helper(int left, int right, string s, vector<string> &ret){
            if(left < 0 || right < 0 || right < left){
                return;
            }
            if(left == 0 && right == 0){
                ret.push_back(s);
                return;
            }
            helper(left - 1, right, s + "(", ret);
            helper(left, right - 1, s + ")", ret);
        }


};
int main(int argc, char* argv[]){
    Solution sol;
    int n = 4;
    vector<string> ret = sol.generateParenthesis(n);
    for(int i = 0; i < ret.size(); i++){
        cout << ret[i] << endl;
    }
}

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
        vector<vector<int> > combine(int n, int k) {
            vector<vector<int> > ret(0);
            vector<int> curr(0);
            vector<int> num(n);
            for(int i = 0; i < n; i++){
                num[i] = i+1;
            }
            helper(0, k, num, curr, ret);
            return ret;
        }
        void helper(int index, int k, vector<int> &num, vector<int> &curr, vector<vector<int> > &ret){
            if(curr.size() == k){
                ret.push_back(curr);
                return;
            }
            for(int i = index; i < num.size(); i++){
                curr.push_back(num[i]);
                helper(i + 1, k, num, curr, ret);
                curr.pop_back();
            }
        }


};
int main(int argc, char* argv[]){
    int n = 4;
    int k = 2;
    Solution sol;
    vector<vector<int> > ret = sol.combine(n, k);
    for(int i = 0; i < ret.size(); i++){
        for(int j = 0; j < ret[i].size(); j++){
            cout << ret[i][j] << " ";
        }
        cout << endl;
    }
}

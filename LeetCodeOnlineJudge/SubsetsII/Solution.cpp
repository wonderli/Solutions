//Given a collection of integers that might contain duplicates, S, return all possible subsets.
#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;
class Solution{
    public:
        vector<vector<int> > subsetsWithDup(vector<int> &S) {
            sort(S.begin(), S.end());
            vector<vector<int> > ret(0);
            vector<int> curr(0);
            helper(0, S, curr, ret);
            return ret;
        }

        void helper(int index, vector<int> &S, vector<int> &curr, vector<vector<int> > &ret){
            if(index == S.size()){
                ret.push_back(curr);
                return ;
            }
            for(int i = index; i < S.size(); i++){
                if(i > index && S[i] == S[i-1]) continue;
                curr.push_back(S[i]);
                helper(i+1, S, curr, ret);
                curr.pop_back();
            }
            helper(S.size(), S, curr, ret);
        }



};
int main(int argc, char* argv[]){
    vector<int> curr;
    curr.push_back(1);
    curr.push_back(2);
    curr.push_back(2);
    Solution sol;
    vector<vector<int> > ret = sol.subsetsWithDup(curr);
    for(int i = 0; i < ret.size(); i++){
        for(int j = 0; j < ret[i].size(); j++){
            cout << ret[i][j] << " ";
        }
        cout << endl;
    }
}

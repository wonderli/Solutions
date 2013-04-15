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
        vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
            vector< vector<int> > ret;
            vector<int> curr;
            if(candidates.size() == 0) return ret;
            sort(candidates.begin(), candidates.end());
            helper(curr, ret, candidates, 0, target);
            return ret;
        }
        void helper(vector<int> &curr, vector< vector<int> > &ret, vector<int> &candidates, int index, int target){
            if(target < 0) return;
            if(target == 0){
                ret.push_back(curr);
                return;
            }
            for(int i = index; i < candidates.size(); i++){
                curr.push_back(candidates[i]);
                helper(curr, ret, candidates, i, target - candidates[i]);
                curr.pop_back();
            }
        }


};
int main(int argc, char* argv[]){
}

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
         vector<vector<int> > combinationSum2(vector<int> &num, int target) {
             vector<vector<int> > ret;
             sort(num.begin(), num.end());
             if(num.size() == 0) return ret;
             vector<int> curr;
             helper(curr, ret, num, 0, target);
         }
         void helper(vector<int> &curr, vector<vector<int> > &ret, vector<int> &num, int index, int target){
             if(target == 0){
                 ret.push_back(curr);
                 return;
             }
             for(int i = index; i < num.size(); i++){
                 if(target < num[i]) break;
                 if(i > index && num[i] == num[i-1]) continue;
                 curr.push_back(num[i]);
                 helper(curr, ret, num, i + 1, target - num[i]);
                 curr.pop_back();
             }
         }


};
int main(int argc, char* argv[]){
}

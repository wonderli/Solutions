#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;
class Solution{
    public:
        vector<vector<int> > permute(vector<int> &num) {
            sort(num.begin(), num.end());
            vector<vector<int> > ret(0);
            vector<int> curr(0);
            bool mark[num.size()];
            for(int i = 0; i < num.size(); i++){
                mark[i] = false;
            }
            helper(mark, num, curr, ret);
            return ret;
        }
        void helper(bool mark[], vector<int> &num, vector<int> &curr, vector<vector<int> > &ret){
            if(curr.size() == num.size()){
                ret.push_back(curr);
                return;
            }
            for(int i = 0; i < num.size(); i++){
                if(!mark[i]){
                    mark[i] = true;
                    curr.push_back(num[i]);
                    helper(mark, num, curr, ret);
                    curr.pop_back();
                    mark[i] = false;
                }
            }
        }


};
int main(int argc, char* argv[]){
    vector<int> num;
    num.push_back(1);
    num.push_back(2);
    num.push_back(3);
    Solution sol;
    vector<vector<int> > ret = sol.permute(num);

    for(int i = 0; i < ret.size(); i++){
        for(int j = 0; j < ret[i].size(); j++){
            cout << ret[i][j] << " ";
        }
        cout << endl;
    }

}

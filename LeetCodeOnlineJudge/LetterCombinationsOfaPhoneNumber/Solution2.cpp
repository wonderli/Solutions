#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#define p(x) cout <<#x<< ": " << x << "\n"
using namespace std;

class Solution{
    public:
        vector<string> letterCombinations(string digits) {
            string pad[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            vector<string> ret;
            string curr;
            helper(ret, curr, 0, digits, pad);
            return ret;
        }
        void helper(vector<string> &ret, string &curr, int index, string digits, string pad[]){
            if(index == digits.length()){
                ret.push_back(curr);
                return;
            }
            string x = pad[digits[index] - '0'];
            for(int i = 0; i < x.length(); i++){
                string t = curr + x[i];
                helper(ret, t, index + 1, digits, pad);
            }
        }


};
int main(int argc, char* argv[]){
    Solution sol;
    vector<string> ret = sol.letterCombinations("222");
    for(int i = 0; i < ret.size(); i++){
        cout << ret[i] << endl;
    }
}

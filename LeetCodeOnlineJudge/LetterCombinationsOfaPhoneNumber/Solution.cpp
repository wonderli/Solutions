#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#define p(x) cout <<#x<< ": " << x << "\n";
using namespace std;

class Solution{
    public:
        vector<string> letterCombinations(string digits) {
            string pad[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            int n = digits.size();
            vector<string> ret;
            vector<string> prefix;
            ret.push_back("");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < ret.size(); j++){
                    string letters = pad[digits[i] - '0'];
                    for(int l = 0; l < letters.size(); l++){
                        string t = ret[j] + letters[l];
                        prefix.push_back(t);
                    }
                }
                ret = prefix;
                prefix.clear();
            }
            return ret;

        }


};
int main(int argc, char* argv[]){
    Solution sol;
    vector<string> ret = sol.letterCombinations("222");
    for(int i = 0; i < ret.size(); i++){
        cout << ret[i] << endl;
    }
}

#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#include <map>
using namespace std;
class Solution{
    public:
         vector<string> anagrams(vector<string> &strs) {
             map<string, vector<string> > dict;
             vector<string> ret;
             int n = strs.size();
             for(int i = 0; i < n; i++){
                 string s(strs[i]);
                 sort(s.begin(), s.end());
                 dict[s].push_back(strs[i]);
             }
             map<string, vector<string> >::iterator iter = dict.begin();
             while(iter != dict.end()){
                 vector<string> curr = iter->second;
                 if(curr.size() > 1){
                     for(int i = 0; i < curr.size(); i++){
                         ret.push_back(curr[i]);
                     }
                 }
                 iter++;
             }
             return ret;
         }
};
int main(int argc, char* argv[]){
    Solution sol;
    vector<string> strs;
    strs.push_back("a");
    strs.push_back("b");
    strs.push_back("a");
    strs.push_back("b");
    strs.push_back("a");
    strs.push_back("b");
    strs.push_back("c");
    vector<string> ret = sol.anagrams(strs);
    for(int i = 0; i < ret.size(); i++){
        cout << ret[i] << endl;
    }
}

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
         vector< vector<string> > solveNQueens(int n) {
             vector< vector<string> > ret;
             vector<int> row(n, 0);
             if(n == 0) return ret;
             helper(ret, row, 0, n);
             return ret;
         }
         void helper(vector< vector<string> > &ret, vector<int> &row, int index, int n){
             if(index == n){
                 ret.push_back(generate(row, n));
                 return;
             }
             for(int i = 0; i < n; i++){
                 if(check(row, index, i, n)){
                     row[index] = i;
                     helper(ret, row, index+1, n);
                 }
             }
         }
         bool check(vector<int> r, int row, int col, int n){
             for(int i = 0; i < row; i++){
                 int x = i;
                 int y = r[i];
                 if(x == row || y == col) return false;
                 if(x - y == row - col || x + y == row + col) return false;
             }
             return true;
         }
         vector<string> generate(vector<int> row, int n){
             vector<string> ret(n);
             for(int i = 0; i < n; i++){
                 string curr;
                 for(int j = 0; j < n; j++){
                     if(row[i] == j){
                         curr.push_back('Q');
                     }else{
                         curr.push_back('.');
                     }
                 }
                 ret[i] = curr;
             }
             return ret;
         }


};
int main(int argc, char* argv[]){
    Solution sol;
    int n = 8;
    vector< vector<string> > ret = sol.solveNQueens(n);
    for(int i = 0; i < ret.size(); i++){
        for(int j = 0; j < ret[i].size(); j++){
            cout << ret[i][j] << endl;
        }
        cout << "---------------" << endl;
    }
}

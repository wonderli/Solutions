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
         int totalNQueens(int n) {
             vector< vector<int> > ret;
             vector<int> row(n, 0);
             if(n == 0) return 0;
             helper(ret, row, 0, n);
             return ret.size();
         }
         void helper(vector< vector<int> > &ret, vector<int> &row, int index, int n){
             if(index == n){
                 ret.push_back(row);
                 return;
             }
             for(int i = 0; i < n; i++){
                 if(check(row, index, i, n)){
                     row[index] = i;
                     helper(ret, row, index+1, n);
                 }
             }
         }
         bool check(vector<int> &r, int row, int col, int n){
             for(int i = 0; i < row; i++){
                 int x = i;
                 int y = r[i];
                 if(x == row || y == col) return false;
                 if(x - y == row - col || x + y == row + col) return false;
             }
             return true;
         }


};
int main(int argc, char* argv[]){
    Solution sol;
}

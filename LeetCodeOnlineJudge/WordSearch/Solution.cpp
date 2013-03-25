//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example,
//Given board =
//
//  [
//  ["ABCE"],
//  ["SFCS"],
//  ["ADEE"]
//  ]
//      word = "ABCCED", -> returns true,
//      word = "SEE", -> returns true,
//      word = "ABCB", -> returns false.
//
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
        bool check(int index, vector<vector<bool> > &mark, vector<vector<char> > &board, string &word, int m, int n, int i, int j){
            if(index == word.length()) return true;
            if(i < 0 || i >= m || j < 0 || j >=n) return false;
            if(board[i][j] != word[index] || mark[i][j]) return false;
            mark[i][j] = true;
            if(check(index+1, mark, board, word, m, n, i+1,j)) return true;
            if(check(index+1, mark, board, word, m, n, i, j+1)) return true;
            if(check(index+1, mark, board, word, m, n, i-1,j)) return true;
            if(check(index+1, mark, board, word, m, n, i,j-1)) return true;
            mark[i][j] = false;
            return false;
        }

        bool exist(vector<vector<char> > &board, string word) {
            int m = board.size();
            int n = board[0].size();
            vector<vector<bool> > mark(m, vector<bool>(n, 0));
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(check(0, mark, board, word, m, n, i, j)) return true;
                }
            }
            return false;
        }
        

};
int main(int argc, char* argv[]){
}

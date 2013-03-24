#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;
class Solution{
    public:
        void setZeroes(vector<vector<int> > &matrix) {
            bool firstCol = false;
            bool firstRow = false;
            int m = matrix.size();
            int n = matrix[0].size();
            for(int i = 0; i < m; i++){
                if(matrix[i][0] == 0){
                    firstCol = true;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
                if(matrix[0][i] == 0){
                    firstRow = true;
                    break;
                }
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(matrix[i][j] == 0){
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for(int i = 1; i < m; i++){
                if(matrix[i][0] == 0){
                    for(int j = 0; j < n; j++){
                        matrix[i][j] = 0;
                    }
                }
            }
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0){
                    for(int i = 0; i < m; i++){
                        matrix[i][j] = 0;
                    }
                }
            }
            if(firstCol){
                for(int i = 0; i < m; i++){
                    matrix[i][0] = 0;
                }
            }
            if(firstRow){
                for(int i = 0; i < n; i++){
                    matrix[0][i] = 0;
                }
            }

        }


};
int main(int argc, char* argv[]){
}

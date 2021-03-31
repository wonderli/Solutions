#include <iostream>
#include <vector>
using namespace std;
int add(vector< vector<int> > &A, vector< vector<int> > &B, int m, int n){
    vector< vector<int> > C(m, vector<int>(n, 0));
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            C[i][j] = A[i][j] + B[i][j];
        }
    }
    int row = 0;
    int col = 0;
    for(int i = 0; i < m; i++){
        bool rflag = true;
        for(int j = 0; j < n; j++){
            if(C[i][j] != 0){
                rflag = false;
            }
        }
        if(rflag == true){
            row++;
        }
    }
    for(int j = 0; j < n; j++){
        bool cflag = true;
        for(int i = 0; i < m; i++){
            if(C[i][j] != 0){
                cflag = false;
            }
        }
        if(cflag == true){
            col++;
        }
    }
    return row + col;

}
int main(){
    int m = 0;
    int n = 0;
    vector<int> v;
    while(cin >> m && m != 0){
        cin >> n;
        vector< vector<int> > A(m, vector<int>(n, 0));
        vector< vector<int> > B(m, vector<int>(n, 0));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                cin >> A[i][j];
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                cin >> B[i][j];
            }
        }
        v.push_back( add(A, B, m, n));

    }
    vector<int>::iterator iter = v.begin();
    for(iter = v.begin(); iter != v.end(); iter++){
        cout << *iter << endl;
    }

}

#include <iostream>
#include <algorithm>
#include <cstdlib>
#define MAX_N 100
#define N 10
using namespace std;
//p(i,j) = max(Ai + min(P(i+2, j), p(i+1, j-1)), Aj + min(P(i+1, j-1), P(i, j-2)));
int pick(int A[], int n){
    int P[MAX_N][MAX_N] = {0};
    int a, b, c;
    int d, i, j;
    for(d = 0; d < n; d++){
        for(i = 0, j = d; j < n; i++, j++){
            a = i+2 < n ? P[i+2][j] : 0;
            b = (i + 1 < n && j - 1 >=0) ? P[i+1][j-1]:0;
            c = j-2 >=0 ? P[i][j-2]:0;
            P[i][j] = max(A[i] + min(a, b), A[j] + max(b,c));
        }
    }
    return P[0][n-1];
}
int main(int argc, char *argv[]){
    int A[N];
    for(int i = 0; i < N; i++){
        A[i] = rand()%10;
        cout << A[i] << " ";
    }
    cout << endl;
    cout << "Max " << pick(A, N) << endl;

}

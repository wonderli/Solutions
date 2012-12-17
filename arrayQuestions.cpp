#include <iostream>
#include <algorithm>
using namespace std;
int LCS(char a[], char b[], int m, int n){
    if(m == 0||n == 0){
        return 0;
    }
    if(a[m-1] == b[n-1]) return LCS(a, b, m-1, n-1) + 1;
    else 
        return max(LCS(a, b, m, n-1), LCS(a, b, m-1, n));
}
int lcs(char a[], char b[], int m, int n){
    int L[m+1][n+1];
    int i, j;
    for(i = 0; i <= m; i++){
        for(j = 0; j <= n; j++){
            if(i == 0 || j == 0){
                L[i][j] = 0;
            }else if(a[i-1] == b[j-1]){
                L[i][j] = L[i-1][j-1] + 1;
            }else
                L[i][j] = max(L[i-1][j], L[i][j-1]);
        }
    }
    return L[m][n];
}
int main(){
    char a[] = "BDCABA";
    char b[] = "ABCBDAB";
    //cout << LCS(a, b, strlen(a), strlen(b)) << endl;
    cout << lcs(a, b, strlen(a), strlen(b)) << endl;
}

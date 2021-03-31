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
int lcsub(char a[], char b[], int m, int n){
    int L[m+1][n+1];
    int maxLen = 0;
    int lastSubsBegin = 0;
    for(int i = 0; i < m+1; i++){
        for(int j = 0; j < n+1; j++){
            if(a[i] != b[j]) L[i][j] = 0; 
            else{
                if(i == 0|j == 0){
                    L[i][j] = 1;
                }else {
                    L[i][j] = 1 + L[i-1][j-1];
                }
                if(L[i][j] > maxLen){
                    maxLen = L[i][j];
                }
            }
        }
    }
    return maxLen;
}
void findMissing(int A[], int n){
    for(int i = 0; i< n; i++){
        cout << A[i] << " ";
    }
    cout << endl;

    for(int i = 0; i< n; i++){
        while(A[i] != i && A[i] != A[A[i]] ){
            swap(A[i], A[A[i]]);
        }
    }
    for(int i = 0; i< n; i++){
        cout << A[i] << " ";
    }
    cout << endl;
    for(int i = 0; i < n; i++){
        if(A[i] != i){
            cout << i << " ";
        }
    }
    cout << endl;

}
int findArraySum(int array[], int n, int sum){
    int curr_sum = array[0];
    int start = 0;
    int i = 0;
    for(i = 1; i < n; i++){
        while(curr_sum > sum && start < i - 1){
            curr_sum = curr_sum - array[start];
            start++;
        }
        if(curr_sum == sum){
            cout << "sum found between indexes " << start << " and " << i - 1 << endl;
            return 1;
        }
        if(i < n){
            curr_sum = curr_sum + array[i];
        }
    }
    cout << "No sum found" << endl;
    return 0;
}

int main(){
    //char a[] = "BDCABA";
    //char b[] = "ABCBDAB";
    //cout << LCS(a, b, strlen(a), strlen(b)) << endl;
    //cout << lcs(a, b, strlen(a), strlen(b)) << endl;
    //cout << lcsub(a, b, strlen(a), strlen(b)) << endl;
    //int array[] = {1,0,0,3,0};
    //findMissing(array, sizeof(array)/sizeof(array[0]));
    int array[] = {15, 2, 4, 8, 9, 5, 10, 23};
    int sum = 23;
    findArraySum(array, sizeof(array)/sizeof(array[0]), sum);
}

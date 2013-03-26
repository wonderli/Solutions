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
        int removeDuplicates(int A[], int n) {
            if(n <= 1) return 1;
            int last = A[0];
            int i = 0;
            int j = 1;
            while(j < n){
                if(A[j] == last){
                    j++;
                }else{
                    A[i+1] = A[j];
                    last = A[i+1];
                    i++;
                    j++;
                }
            }
            return i + 1;
        }


};
void printArray(int A[], int n){
    for(int i = 0; i < n; i++){
        cout << A[i] << " ";
    }
    cout << endl;
}
int main(int argc, char* argv[]){
    int A[] = {1, 1, 2};
    Solution sol;
    printArray(A, 3);
    cout << sol.removeDuplicates(A, 3) << endl;
    printArray(A, 3);
}

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
            if(n < 3) return 1;
            int j = 2;
            int i = 2;
            while(i < n){
                if(A[i] != A[j - 1] || A[i] != A[j - 2]){
                    j++;
                    A[j] = A[i];
                }
                i++;
            }
            return j;
        }


};
int main(int argc, char* argv[]){
}

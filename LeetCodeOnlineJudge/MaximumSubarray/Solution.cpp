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
         int maxSubArray(int A[], int n) {
             int max = INT_MIN;
             int i = 0;
             int current = 0;
             bool neg = true;
             for(int i = 0; i < n; i++){
                 if(A[i] > 0){
                     neg = false;
                 }
             }
             if(neg){
                 int max = A[0];
                 for(int i = 1; i < n; i++){
                     max = (max > A[i]) ? max : A[i];
                 }
                 return max;
             }
             i = 0;
             while(i < n){
                 current += A[i];
                 if(current < 0){
                     current = 0;
                 }
                 if(current > max){
                     max = current;
                 }
                 i++;
             }
             return max;
         }


};
int main(int argc, char* argv[]){
}

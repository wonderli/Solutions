#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
class Solution{
    public:
        int removeElement(int A[], int n, int elem) {
            if(n < 1) return 0;
            int i = -1;
            int j = 0;
            while(j < n){
                if(A[j] == elem){
                    j++;
                }else{
                    A[i+1] = A[j];
                    i++;
                    j++;
                }
            }
            return i + 1;
        }


};
int main(int argc, char* argv[]){
}

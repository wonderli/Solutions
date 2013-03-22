//Given two sorted integer arrays A and B, merge B into A as one sorted array.
#include <iostream>
class Solution{
    public:
        void merge(int A[], int m, int B[], int n) {
            if(n == 0) return;
            if(m == 0){
                for(int i = 0; i < n; i++){
                    A[i] = B[i];
                }
                return;
            }
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while(k >= 0){
                if(i >= 0 && j >= 0 && B[j] > A[i]){
                    A[k] = B[j];
                    j--;
                    k--;
                }else if(i >= 0 && j >= 0 && B[j] <= A[i]){
                    A[k] = A[i];
                    i--;
                    k--;
                }else if(i < 0 && j >=0){
                    A[k] = B[j];
                    j--;
                    k--;
                }else if(i >= 0 && j < 0){
                    A[k] = A[i];
                    i--;
                    k--;
                }
            }
        }

};
int main(int argc, char* argv[]){
}

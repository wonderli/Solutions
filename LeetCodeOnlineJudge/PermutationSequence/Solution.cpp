//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"

//Given n and k, return the kth permutation sequence.

#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
using namespace std;
class Solution{
    public:
        string getPermutation(int n, int k) {
            stringstream ss;
            vector<int> fac(n);
            fac[0] = 1;
            for(int i = 1; i < n; i++){
                fac[i] = fac[i-1] * i;
            }
            vector<int> list;
            for(int i = 1; i <= n; i++){
                list.push_back(i);
            }
            --k;
            for(int i = n - 1; i >= 1; i--){
                int idx = k / fac[i];
                ss << list[idx];
                list.erase(list.begin() + idx);
                k = k % fac[i];
            }
            ss << list[0];
            return ss.str();
        }


};
int main(int argc, char* argv[]){
    Solution sol;
    cout << sol.getPermutation(3,2);
}

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution{
    public:
        vector<vector<int> > threeSum(vector<int> &num) {
            sort(num.begin(), num.end());
            int n = num.size();
            vector<vector<int> > ret;
            vector<int> curr(3);
            for(int i = 0; i < n - 2; i++){
                if(i > 0 && num[i] == num[i-1]) continue;
                int j = i + 1;
                int k = n - 1;
                int goal = 0 - num[i];
                curr[0] = num[i];
                while(j < k){
                    while(j < k && num[j] + num[k] < goal) j++;
                    while(j < k && num[j] + num[k] > goal) k--;
                    if(j < k && num[j] + num[k] == goal){
                        curr[1] = num[j];
                        curr[2] = num[k];
                        ret.push_back(curr);
                        j++;
                        k--;
                        while(j < k && num[j] == num[j-1]) j++;
                        while(j < k && num[k] == num[k+1]) k--;
                    }
                }
            }
            return ret;
        }

};
int main(int argc, char* argv[]){
}

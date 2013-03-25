#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
class Solution{
    public:
         int sqrt(int x) {
             long long l = 0;
             long long r = x;
             long long ret  = 0;
             while(l <= r){
                 long long mid = l + (r - l)/2;
                 long long result = mid * mid;
                 if(result == x){
                     ret = mid;
                     return (int)ret;
                 }else if(result < x){
                     l = mid + 1;
                 }else{
                     r = mid - 1;
                 }
             }
             return (int)r;
         }


};
int main(int argc, char* argv[]){
}

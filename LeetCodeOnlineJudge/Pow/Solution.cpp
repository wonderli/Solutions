#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;
class Solution{
    public:
        //double pow(double x, int n) {
        //    if(n == 0) return 1;
        //    if(n == 1) return x;
        //    if(n < 0){
        //        n = -n;
        //        return 1/(pow(x, n/2) * pow(x, n/2) * pow(x, n%2));
        //    }
        //    return pow(x, n/2) * pow(x, n/2) * pow(x, n%2);
        //}

        double pow(double x, int n){
            bool flag = false;
            if(n < 0){
                n = -n;
                flag = true;
            }
            if(n == 0) return 1;
            double pow = x;
            double ret = 1.0;
            while(n > 0){
                if(n%2 == 1){
                    ret *= pow;
                }
                pow *= pow;
                n = n/2;
            }
            if(flag) return 1/ret;
            return ret;
        }

};
int main(int argc, char* argv[]){
}

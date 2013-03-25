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
        int romanToInt(string s){
           if(s.length() == 0) return 0; 
           vector<int> value(256, 0);
           value['#'] = 0;
           value['I'] = 1;
           value['V'] = 5;
           value['X'] = 10;
           value['L'] = 50;
           value['C'] = 100;
           value['D'] = 500;
           value['M'] = 1000;
           s = s+ "#";
           int ret = 0;
           for(int i = 0; i < s.length() - 1; i++){
               if(value[s[i]] < value[s[i+1]]){
                   ret = ret - value[s[i]];
               }else{
                   ret = ret + value[s[i]];
               }
           }
           return ret;
        }


};
int main(int argc, char* argv[]){
}

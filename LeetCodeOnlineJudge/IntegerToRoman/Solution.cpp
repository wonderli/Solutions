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
        string intToRoman(int num) {
            stringstream ss;
            string ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            string tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            string hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            while(num >= 1000){
                num -= 1000;
                ss << "M";
            }
            string h = hundreds[num/100];
            num = num % 100;
            string t = tens[num/10];
            num = num % 10;
            string o = ones[num];
            ss << h << t << o;
            return ss.str();
        }


};
int main(int argc, char* argv[]){
    int num = 3224;
    Solution sol;
    cout << sol.intToRoman(num) << endl;
}

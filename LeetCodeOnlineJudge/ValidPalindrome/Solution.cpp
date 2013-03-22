//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
#include <iostream>
using namespace std;
class Solution{
    public:
        bool isPalindrome(string s) {
            int l = 0;
            int r = s.length() - 1;
            while(l < r){
                while(l < r && !isdigit(s[l]) && !isalpha(s[l])){
                    l++;
                }
                while(l < r && !isdigit(s[r]) && !isalpha(s[r])){
                    r--;
                }
                if(l < r){
                    if(tolower(s[l]) != tolower(s[r])) return false;
                    else{
                        l++;
                        r--;
                    }
                }
            }
            return true;
        }

};
int main(int argc, char* argv[]){
    //string s("A man, a plan, a cannal: Panama");
    string s("race a car");
    Solution sol;
    cout << sol.isPalindrome(s) << endl;
}

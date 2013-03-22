#include <iostream>
#include <stack>
using namespace std;
class Solution{
    public:
        bool isValid(string s){
            int n = s.length();
            stack<int> stack;
            for(int i = 0; i < n; i++){
                if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
                    stack.push(s[i]);
                }
                else{
                    if(!stack.empty() && match(stack.top(), s[i])){
                        stack.pop();
                    }else return false;
                }
            }
            return stack.empty();
        }
        bool match(char a, char b){
            if(a == '(') return b == ')';
            if(a == '[') return b == ']';
            if(a == '{') return b == '}';
        }

};
int main(int argc, char* argv[]){
    string s("([");
    Solution sol;
    cout << sol.isValid(s);
}

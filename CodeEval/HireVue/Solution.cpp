#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
#include <cstring>
#include <fstream>
#define p(x) std::cout << #x << ": " << x << std::endl
using namespace std;
void helper(string &a, string &b, vector<char> &ret){
    int m = atoi(const_cast<char *>(b.c_str()));
    vector<char> array;
    for(int i = 0; i < a.length(); i++){
        if(a[i] == ' ') continue;
        array.push_back(a[i]);
    }
    //vector<char>::iterator iter = array.begin();
    //for(;iter!=array.end();iter++){
    //    cout << *iter << " ";
    //}
    //cout << endl;
    int len = array.size();
    if(m > len) return;
    ret.push_back(array[len - m]);
}
int main(int argc, char* argv[]){
    ifstream file;
    file.open(argv[1]);
    string lineBuffer;
    vector<char> ret;
    while (!file.eof()) 
    {
        getline(file, lineBuffer);
        if (lineBuffer.length() == 0)
            continue; //ignore all empty lines
        else 
        {
            int index = lineBuffer.find_last_of(" ");
            string a = lineBuffer.substr(0, index);
            string b = lineBuffer.substr(index+1);
            helper(a, b, ret);
        }
    }
    for(vector<char>::iterator iter = ret.begin(); iter != ret.end(); iter++){
        cout << *iter << endl;
    }

}

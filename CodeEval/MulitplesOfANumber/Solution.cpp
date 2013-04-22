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
void helper(string &a, string &b, vector<int> &ret){
    int av = atoi(const_cast<char *>(a.c_str()));
    int bv = atoi(const_cast<char *>(b.c_str()));
    int i = 1;
    while(bv * i < av){
        i++;
    }
    ret.push_back(bv*i);
}
int main(int argc, char* argv[]){
    ifstream file;
    file.open(argv[1]);
    string lineBuffer;
    vector<int> ret;
    while (!file.eof()) 
    {
        getline(file, lineBuffer);
        if (lineBuffer.length() == 0)
            continue; //ignore all empty lines
        else 
        {
            int index = lineBuffer.find(",");
            string a = lineBuffer.substr(0, index);
            string b = lineBuffer.substr(index+1);
            helper(a, b, ret);
        }
    }
    for(vector<int>::iterator iter = ret.begin(); iter != ret.end(); iter++){
        cout << *iter << endl;
    }

}

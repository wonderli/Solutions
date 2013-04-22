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
void reverse(string &line, int l, int r){
    while(l < r){
        char tmp = line[l];
        line[l] = line[r];
        line[r] = tmp;
        l++;
        r--;
    }
}
void helper(string &line, vector<string> &ret){
    int len = line.length();
    int l = 0;
    int r = len - 1;
    reverse(line, l, r);
    int begin = 0;
    int i = 0;
    while(i < len){
        if(line[i] == ' '){
            reverse(line, begin, i-1);
            i++;
            while(line[i] == ' ') i++;
            begin = i;
        }
        i++;
    }
    reverse(line, begin, len - 1);
    ret.push_back(line);
}
int main(int argc, char* argv[]){
    ifstream file;
    file.open(argv[1]);
    string lineBuffer;
    vector<string> ret;
    while (!file.eof()) 
    {
        getline(file, lineBuffer);
        if (lineBuffer.length() == 0)
            continue; //ignore all empty lines
        else 
        {
            helper(lineBuffer, ret);
        }
    }
    for(vector<string>::iterator iter = ret.begin(); iter != ret.end(); iter++){
        cout << *iter << endl;
    }

}

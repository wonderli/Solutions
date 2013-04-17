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
            int index = lineBuffer.find(";");
        }
    }
    //for(vector<string>::iterator iter = ret.begin(); iter != ret.end(); iter++){
    //    cout << *iter << endl;
    //}

}

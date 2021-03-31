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
void helper(string a, string b, vector< vector<int> > &ret){
    char *pch = NULL;
    vector<int> av;
    vector<int> bv;
    pch = strtok(const_cast<char *>(a.c_str()), ",");
    while(pch != NULL){
        int t = atoi(pch);
        pch = strtok(NULL, ",");
        av.push_back(t);
    }
    pch = strtok(const_cast<char*>(b.c_str()), ",");
    while(pch != NULL){
        int t = atoi(pch);
        pch = strtok(NULL, ",");
        bv.push_back(t);
    }
    int i = 0;
    int j = 0;
    int aSize = av.size();
    int bSize = bv.size();
    vector<int> curr;
    while(i < aSize && j < bSize){
        if(av[i] == bv[j]){
            curr.push_back(av[i]);
            i++;
            j++;
        }else if(av[i] < bv[j]){
            i++;
        }else if(av[i] > bv[j]){
            j++;
        }
    }
    ret.push_back(curr);
}
int main(int argc, char* argv[]){
    ifstream file;
    file.open(argv[1]);
    string lineBuffer;
    vector< vector<int> > ret;
    while (!file.eof()) 
    {
        getline(file, lineBuffer);
        if (lineBuffer.length() == 0)
            continue; //ignore all empty lines
        else 
        {
            int index = lineBuffer.find(";");
            string a = lineBuffer.substr(0, index);
            string b = lineBuffer.substr(index+1);
            helper(a, b, ret);
        }
    }
    for(vector< vector<int> >::iterator iter = ret.begin(); iter != ret.end(); iter++){
        //if((*iter).size() == 1){
        //    cout << (*iter)[0] << endl;
        //}else{
            for(vector<int>::iterator iter2 = (*iter).begin(); iter2 != (*iter).end(); iter2++){
                if(iter2 != ((*iter).end() -1)){
                    cout << *iter2 << ",";
                }else{
                    cout << *iter2;
                }
            }
            cout << endl;
        //}
    }

}

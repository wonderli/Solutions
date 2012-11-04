#include <iostream>
#include <string>
using namespace std;
int lengthOfLongestSubstring(string str){
    int size = 256;
    bool charmap[size];
    int charpos[size];
    int maxLength = 0;
    int currLength = 0;
    string longest;
    string curr;
    int i = 0;
    while(i < str.length()){
        if(charmap[str[i]] == false){
            charmap[str[i]] = true;
            charpos[str[i]] = i;
            curr.push_back(str[i]);
            currLength++;
            if(currLength >= maxLength){
                maxLength = currLength;
                longest = curr;
            }
        }else{
            curr.clear();
            currLength = 0;
            i = charpos[str[i]];
            for(int j = 0; j < size; j++){
                charmap[j] = false;
                charpos[j] = 0;
            }
            i++;
            continue;
        }
        i++;
    }
    cout << longest << endl;
    return maxLength;
}


int main(){
    //string str("abcabcbb");
    //string str("bbb");
    //string str("inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating");
    string str("endtomfgdwdwfcgpxiqvkuytdlcgd");
    int len = lengthOfLongestSubstring(str);
    cout << len << endl;
    return 0;
}

#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;
//int getDistance(char *s, char *ss, int len){
//    int distance = 0;
//    for(int i = 0; i < len; i++){
//        if(*(s+i) == *(ss+i)) distance++;
//        else break;
//    }
//    return distance;
//}
//int stringSimilar(char *s, int len){
//    char ss[len];
//    int d[len];
//    for(int i = 0; i < len; i++){
//        strcpy(ss, s+i);
//        d[i] = getDistance(s, ss, len-i);
//    }
//    int ret = 0;
//    for(int i = 0; i < len; i++){
//        ret += d[i];
//    }
//    return ret;
//}
int stringSimilar(char *s, int len){
    int d = 0;
    int i = 0;
    int j = 0;
    int begin = 0;
    int curr = 0;
    for(begin = 0; begin < len; begin++){
        for(i = 0, j = 0; i < len - begin; i++){
            if(*(s+i) == *(s + i + begin)){
                curr++;
            }else{
                break;
            }
        }
        d += curr;
        curr = 0;
    }
    return d;
}
int main(){
    int T = 0;
    cin >> T;
    string s[T];
    int res[T];
    char *sc;
    for(int i = 0; i < T; i++){
        cin >> s[i];
        char *sc = const_cast<char *>(s[i].c_str());
        int len = s[i].length();
        res[i] = stringSimilar(sc, len);
    }
    for(int i = 0; i < T; i++){
        cout << res[i] << endl;
    }
}

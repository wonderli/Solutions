#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#define RIGHTDOWN 1
#define DOWN 2
#define RIGHT 3
#define MAX 1024

using namespace std;
void printPath(int path[][MAX], char *s1, char *s2, int i,int j){
    if(i < 0 || j < 0) return;
    if(path[i][j] == RIGHTDOWN){
        printPath(path, s1, s2, i-1, j-1);
        cout << s1[i];
    }else if(path[i][j] == DOWN){
        printPath(path, s1, s2, i-1, j);
    }else if(path[i][j] == RIGHT){
        printPath(path, s1, s2, i, j-1);
    }
}

int findLcs(char *s1, char *s2){
    if(s1 == NULL || s2 == NULL) return 0;
    int len1 = strlen(s1);
    int len2 = strlen(s2);
    int lcs[len1][len2];
    int path[MAX][MAX];
    for(int row = 0; row < len1; row++){
        for(int col = 0; col < len2; col++){
            lcs[row][col] = 0;
            path[row][col] = 0;
        }
    }
    int i = 0;
    int j = 0;
    for(i = 0; i < len1; i++){
        for(j = 0; j < len2; j++){
            if(i == 0 || j == 0){
                if(s1[i] == s2[j]){
                    lcs[i][j] = 1;
                    path[i][j] = RIGHTDOWN;
                }else{
                    lcs[i][j] == 0;
                }
            }
            else if(s1[i] == s2[j]){
                lcs[i][j] = lcs[i-1][j-1] + 1;
                path[i][j] = RIGHTDOWN;
            }else if(lcs[i-1][j] > lcs[i][j-1]){
                lcs[i][j] = lcs[i-1][j];
                path[i][j] = DOWN;
            }else if(lcs[i][j-1] > lcs[i-1][j]){
                lcs[i][j] = lcs[i][j-1];
                path[i][j] = RIGHT; 
            }

        }
    }
    cout << lcs[len1-1][len2-1] << endl;
    printPath(path, s1, s2, len1-1, len2-1);
}

int main(){
    string s1;
    string s2;
    cin >> s1;
    cin >> s2;
    char *str1 = const_cast<char *>(s1.c_str());
    char *str2 = const_cast<char *>(s2.c_str());
    //cout << s1.length() << endl;
    //cout << s2.length() << endl;
    findLcs(str1, str2);
}

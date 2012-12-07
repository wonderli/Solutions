#include <iostream>
using namespace std;
void printMap(int map[], int n){
    for(int i = 0; i < n; i++){
        cout << map[i] << " ";
    }
    cout << endl;
}
void findChar(char input[], int n){
    int mapsize = 256;
    int map[mapsize];
    for(int i = 0; i < mapsize; i++){
        map[i] = 0;
    }
    for(int i = 0; i < n; i++){
        map[input[i]]++;
    }
    for(int i = 0; i < mapsize; i++){
        if(map[i] == 1){
            cout << (char)i << endl;
        }
    } 
}
int main(){
    char input[] = "abcdabcde";
    int len = strlen(input);
    cout << input << endl;
    findChar(input, len);

}

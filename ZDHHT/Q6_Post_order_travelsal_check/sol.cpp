#include <iostream>
using namespace std;
bool checkPostOrder(int sequence[], int begin, int end){
    if(begin < end){
        if(!sequence) return false;
        int root = sequence[end - 1];
        int i = 0;
        int j = 0;
        for(i = begin; i < end - 1; i++){
            if(sequence[i] > root){
                break;
            }
        }
        for(j = i; j < end - 1; j++){
            if(sequence[j] < root){
                return false;
            }
        }
        int leftBegin = begin;
        int leftEnd = i - 1;
        int rightBegin = i;
        int rightEnd = end -1;
        bool leftResult = checkPostOrder(sequence, leftBegin, leftEnd);
        bool rightResult = checkPostOrder(sequence, rightBegin, rightEnd);
        return leftResult && rightBegin;
    }else{
        return true;
    }

}
int main(){
    int sequence[] = {5,7,6,9,11,10,8};
    //int sequence[] = {7,4,6,5};
    int size = sizeof(sequence)/sizeof(sequence[0]);
    bool result =  checkPostOrder(sequence, 0, size);
    cout << result << endl;

}

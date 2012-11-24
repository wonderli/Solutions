#include<iostream>
using namespace std;

int main()
{
    //int *ptr = NULL;
    int *ptr;
    *ptr = 4;
    int &ref = *ptr;
    cout << ref << endl;
}



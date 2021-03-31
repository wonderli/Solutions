#include<iostream>
using namespace std;

int fun(int &x)
{
    return x;
}
int main()
{
//    cout << fun(10);
    int x = 10;
    cout << fun(x);
    return 0;
}

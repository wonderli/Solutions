//reference to value at uninitialized pointer.
//reference to a local variable is returned.
#include <iostream>
using namespace std;
int main(){
    int *ptr;
    *ptr = 3;
    int &ref = *ptr;
    cout << "*ptr " << *ptr << endl;
    cout << "ref " << ref << endl;
    *ptr = 4;
    cout << "*ptr " << *ptr << endl;
    cout << "ref " << ref << endl;
    int *ptr2;
    int &ref2 = *ptr2;//Reference to value at some memory location, not determined.

}

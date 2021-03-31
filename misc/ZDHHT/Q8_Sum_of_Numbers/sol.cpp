#include <iostream>
using namespace std;
class Sol{
    public:
        static int N;
        static int Sum;
        Sol(){
            N++;
            Sum += N;
        }
};
int Sol::N = 0;
int Sol::Sum = 0;

int main(){
    int n = 100;
    Sol *sol = new Sol[n];
    delete []sol;
    sol = 0;
    cout << Sol::Sum << endl;

}

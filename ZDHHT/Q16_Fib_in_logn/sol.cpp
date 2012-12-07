#include <iostream>
using namespace std;
struct Matrix2By2{
    long long m_00;
    long long m_01;
    long long m_10;
    long long m_11;
    Matrix2By2 (
        long long m00 = 0,
        long long m01 = 0,
        long long m10 = 0,
        long long m11 = 0
        ) : m_00(m00), m_01(m01), m_10(m10), m_11(m11){
    }
};
Matrix2By2 MatrixMultiply(const Matrix2By2 &matrix1, const Matrix2By2 &matrix2){
    return Matrix2By2(
            matrix1.m_00 * matrix2.m_00 + matrix1.m_01 * matrix2.m_10,
            matrix1.m_00 * matrix2.m_01 + matrix1.m_01 * matrix2.m_11,
            matrix1.m_10 * matrix2.m_00 + matrix1.m_11 * matrix2.m_10,
            matrix1.m_10 * matrix2.m_01 + matrix1.m_11 * matrix2.m_11
            );
}
Matrix2By2 MatrixPower(unsigned int n){
    Matrix2By2 matrix;
    if(n == 1){
        matrix = Matrix2By2(1,1,1,0);
    }
    else if(n%2 == 0){
        matrix = MatrixPower(n/2);
        matrix = MatrixMultiply(matrix, matrix);
    }else if(n%2 == 1){
        matrix = MatrixPower((n-1)/2);
        matrix = MatrixMultiply(matrix, matrix);
        matrix = MatrixMultiply(matrix, Matrix2By2(1, 1, 1, 0));
    }
    return matrix;
}
long long f(unsigned int n){
    int result[2] = {0, 1};
    if(n < 2)
        return result[n];
    Matrix2By2 powerNminus = MatrixPower(n-1);
    return powerNminus.m_00;
}
int main(){
    cout << f(15) << endl;
}






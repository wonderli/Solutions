#!/usr/bin/env python
def add(A, B):
    n = len(A)
    C = [0 for i in range(0, n+1)]
    carry = 0
    for i in range(n-1, -1, -1):
        s = A[i] + B[i] + carry
        C[i+1] = s%2
        carry = s/2
    C[0] = carry
    print C

    
A = [0,1,1]
B = [0,1,1]
add(A, B)



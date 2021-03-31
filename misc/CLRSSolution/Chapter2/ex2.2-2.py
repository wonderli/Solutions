#!/usr/bin/env python
import random
def selection_sort(A):
    length = len(A)
    for i in range(0, length-1):
        smallest = i
        j = i
        while j < length:
            if A[j] < A[smallest]:
                smallest = j
            j = j + 1
        tmp = A[i]
        A[i] = A[smallest]
        A[smallest] = tmp

    print A
A = [3, 2, 1, 0]
B = [random.randint(0, 100) for i in range(0, 10)]
print A
selection_sort(A)
print B
selection_sort(B)


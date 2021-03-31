#!/usr/bin/env python2.7
import sys
import math
def solve(s):
    s = int(s)
    j = int(math.sqrt(s))
    count = 0
    k = 0
    while k <= j:
        if int(k*k + j*j) == s:
            count += 1
            k += 1
            j -= 1
        elif k*k + j*j > s:
            j -= 1
        else:
            k += 1
    return count



test_cases = open(sys.argv[1], 'r')
test_cases.readline()
for test in test_cases:
    test = test.rstrip("\n")
    print solve(test)

test_cases.close()

#!/usr/bin/env python2.7
import sys
def solve(s):
    a,b = s.split(",")
    len_a = len(a)
    len_b = len(b)
    if len_a < len_b: return 0
    i = len_b - 1
    j = len_a - 1
    while i > 0:
        if a[j] != b[i]:
            return 0
        i -= 1
        j -= 1
    return 1




test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    print solve(test)

test_cases.close()

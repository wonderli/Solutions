#!/usr/bin/env python2.7
import sys
def solve(s):
    a = ""
    s = int(s)
    while s > 0:
        a = str(s & 1) + a
        s >>= 1
    return a




test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    print solve(test)

test_cases.close()

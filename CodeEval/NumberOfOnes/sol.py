#!/usr/bin/env python2.7
import sys
def solve(s):
    s = int(s)
    count = 0
    while s != 0:
        s = s & (s - 1)
        count += 1
    print count


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    solve(test)

test_cases.close()

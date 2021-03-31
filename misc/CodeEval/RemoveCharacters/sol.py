#!/usr/bin/env python2.7
import sys
def solve(a, b):
    length = len(a)
    a = list(a)
    j = 0
    for i in range(0, length):
        if b.find(a[i]) == -1:
            a[j] = a[i]
            j += 1
            i += 1
        else:
            i += 1

    a = a[0:j]
    a = "".join(a)

    print a


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    a,b = test.split(", ")
    solve(a, b)

test_cases.close()

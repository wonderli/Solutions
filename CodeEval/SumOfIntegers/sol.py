#!/usr/bin/env python2.7
import sys
def checkNeg(a):
    for e in a:
        if e >= 0:
            return False
    return True

def solve(s):
    a = [int(e) for e in s.split(",")]
    val = 0
    if checkNeg(a) == True:
        return max(a)

    length = len(a)
    sum_val = 0
    for i in range(0, length):
        sum_val = sum_val + a[i]
        if sum_val > val :
            val = sum_val
        elif sum_val < 0:
            sum_val = 0
    return val


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    print solve(test)

test_cases.close()

#!/usr/bin/env python2.7
import sys
def solve(a):
    count = 0
    while check(a) == False :
        r = a[::-1]
        a = int(a) + int(r)
        count += 1
        a = str(a)
    print count, a

def check(s):
    s = list(str(s))
    i = 0
    j = len(s) - 1
    while i < j:
        if s[i] != s[j]:
            return False
        i += 1
        j -= 1
    return True



test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    solve(test)

test_cases.close()

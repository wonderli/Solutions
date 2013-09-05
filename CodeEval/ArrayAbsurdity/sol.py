#!/usr/bin/env python2.7
import sys

def anothersolve(s):
    first, second = s.split(";")
    first = int(first)
    A = [int(e) for e in second.split(",")]
    x1 = A[0]
    x2 = 0
    for e in range(1, len(A)):
        x1 = x1 ^ A[e]
    for e in range(1, first-1):
        x2 = x2 ^ e
    print x1 ^ x2






test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    if test != "":
        anothersolve(test)

test_cases.close()

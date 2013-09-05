#!/usr/bin/env python2.7
import sys
def solve(s):
    first, second = s.split(";")
    first = [ int(e) for e in first.split(",")]
    second = int(second)
    second = int(second)
    ret = []
    first.sort()
    i = 0
    j = len(first) - 1
    while i < j:
        if first[i] + first[j] == second:
            ret.append(str(first[i]) + "," + str(first[j]))
            i += 1
            j -= 1
        elif first[i] +first[j] > second:
            j -= 1
        else:
            i += 1
    ret = ";".join(ret)
    if len(ret) == 0:
        print "NULL"
        return
    print ret

test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    solve(test)

test_cases.close()

#!/usr/bin/env python2.7
import sys
def solve(s):
    d = {}
    length = len(s)
    for i in range(0, length):
        r = d.get(s[i], None)
        if r == None:
            d[s[i]] = 1
        else:
            d[s[i]] += 1

    last = sys.maxint
    for k in d.keys():
        if d[k] == 1:
            curr = s.find(k)
            if curr < last:
                last = curr
    print s[last]


test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    solve(test)

test_cases.close()

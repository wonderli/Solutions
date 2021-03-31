#!/usr/bin/env python2
import sys
def solve(l):
    a = []
    ret = []
    for e in l:
        a.append(e)
    counter = 0
    while len(a) != 0:
        x = a.pop()
        if counter % 2 == 0:
            ret.append(x)
            ret.append(" ")
        counter += 1

    print "".join(ret)


if __name__ == "__main__":
    test_cases = open(sys.argv[1], 'r')
    for test in test_cases:
        test = test.strip()
        l = test.split(" ")
        solve(l)
    test_cases.close()

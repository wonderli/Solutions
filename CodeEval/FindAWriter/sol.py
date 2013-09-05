#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], "r")
for test in test_cases:
    test = test.strip("\n")
    if test != "":
        s = test.split("| ")
        vS = s[0]
        kS = s[1]
        k = kS.split(" ")
        r = ""
        for e in k:
            r = r + (vS[int(e)-1])
        print r
test_cases.close()

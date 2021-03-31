#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], "r")
for test_case in test_cases:
    test_case = test_case.strip()
    if test_case != "":
        test_case = test_case.lower()
        d = {}
        for e in test_case:
            x = ord(e) - ord('a')
            if x >= 0 and x < 26:
                if d.has_key(e):
                    d[e] += 1
                else:
                    d[e] = 1
        d = sorted(d.items(), key=lambda x:x[1], reverse=True)
        e = 26
        r = 0
        for i in range(0, len(d)):
            r += e * d[i][1]
            e = e - 1
        print r



test_cases.close()

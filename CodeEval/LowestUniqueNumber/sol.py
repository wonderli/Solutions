#!/usr/bin/env python2
import sys
from collections import Counter
test_cases = open(sys.argv[1],'r')
for test in test_cases:
    test = test.strip("\n")
    l = test.split(" ")
    cnt = Counter(l)
    r = -1
    for i in range(0, len(l)):
        if cnt[l[i]] == 1:
            if r == -1:
                r = i
            elif l[r] > l[i]:
                r = i
    r = r + 1
    if r == -1:
        r = 0
    print r





test_cases.close()

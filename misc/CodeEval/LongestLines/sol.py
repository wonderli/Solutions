#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], 'r')
N = int(test_cases.readline().strip())
l = [line.strip() for line in test_cases if line.strip() != ""]
l = sorted(l, key=len)
l.reverse()
for i in range(0, N):
        print l[i]

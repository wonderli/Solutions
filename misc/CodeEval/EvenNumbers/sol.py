#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.strip('\n')
    num = int(test)
    if num%2 == 0:
        print 1
    else:
        print 0

test_cases.close()

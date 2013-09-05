#!/usr/bin/env python2.7
import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    l =  test.split(' ')
    print l[-2]

test_cases.close()

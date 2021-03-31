#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.strip('\n')
    l = test.split(' ')
    r = ''
    for e in l:
        a = ''
        if e[0] >= 'a' and  e[0] <= 'z' :
            a = chr(ord(e[0]) - ord('a') + ord('A'))
        else:
            a = e[0]
        r = r + a
        r = r + e[1:]
        r = r + " "

    print r


test_cases.close()

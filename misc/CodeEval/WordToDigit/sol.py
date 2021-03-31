#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], 'r')
d = {'zero':0, 'one':1, 'two':2, 'three':3, 'four':4, 'five':5, 'six':6, 'seven':7, 'eight':8, 'nine':9}
for test in test_cases :
    test = test.strip();
    if test != "" :
        ret = []
        l = test.split(";")
        for e in l:
            ret.append(str(d[e]))
        print "".join(ret)
test_cases.close()

#!/usr/bin/env python2
import sys
def detect_cycles(line):
    l = line.split(" ")
    l_len = len(l)
    current_len = 0
    start = 0
    i = 0
    while i < l_len:
        j = i + 1
        while j < l_len - i :
            if l[i] == l[j] :
                k = 0
                while i + k < j and j + k < l_len and l[i+k] == l[j+k]:
                    k += 1
                if k > current_len:
                    start = i
                    current_len = k
            j += 1
        i += 1
    if current_len != 0:
        ret = " "
        print ret.join(l[start:start+current_len])




if __name__ == "__main__":
    test_cases = open(sys.argv[1], 'r')
    for test in test_cases:
        test = test.strip()
        if test != '':
            detect_cycles(test)

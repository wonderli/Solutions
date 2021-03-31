#!/usr/bin/env python2
import sys
def solve(line):
    l = [0] * 26;
    for e in line:
        if e >= 'a' and e <= 'z':
            l[ord(e) - ord('a')] += 1
    r = []
    for i in range(0, len(l)):
        if l[i] == 0:
            r.append(chr(i + ord('a')))
    if len(r) == 0:
        return "NULL"
    else:
        return "".join(r)



if __name__ == "__main__":
    test_cases = open(sys.argv[1],'r')
    for test in test_cases:
        test = test.lower()
        print solve(test)
    test_cases.close()

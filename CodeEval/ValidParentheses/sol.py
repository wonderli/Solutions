#!/usr/bin/env python2.7
import sys
def solve(s):
    l = []
    l.append(s[0])
    for e in s[1:]:
        if e == '(' or e == '{' or e == '[':
            l.append(e)
        else:
            if len(l) == 0: return False
            b = l.pop(-1)
            if check(b, e) == False : return False
    return len(l) == 0


def check(a, b):
    if a == '(': return True if b == ')' else False
    if a == '{': return True if b == '}' else False
    if a == '[': return True if b == ']' else False



test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.rstrip("\n")
    print solve(test)

test_cases.close()

#!/usr/bin/env python
import sys
def reverse_complement(argv):
    str = argv[1]
    s = list(str)
    for index in range(0, len(s)):
        if s[index] == 'A':
            s[index] = 'T'
        elif s[index] == 'T':
            s[index] = 'A'
        elif s[index] == 'C':
            s[index] = 'G'
        elif s[index] == 'G':
            s[index] = 'C'

    new_s = s[::-1]
    new_str = "".join(new_s)
    print new_str
if __name__ == '__main__':
    reverse_complement(sys.argv)

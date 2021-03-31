#!/usr/bin/env python
import sys
def RNAT(argv):
    filename = argv[1]
    f = open(filename, 'r')
    str = f.read()
    print str
    s = list(str)
    for index in range(0, len(s)):
        if s[index] == 'T':
            s[index] = 'U'
    new_str = "".join(s)
    print new_str


if __name__ == '__main__':
    RNAT(sys.argv)

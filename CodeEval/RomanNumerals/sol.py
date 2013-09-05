#!/usr/bin/env python2
import sys
test_cases = open(sys.argv[1], "r")
ones = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
tens = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
huns = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
for test in test_cases:
    test = test.strip("\n")
    num = int(test)
    ret = ""
    while(num >= 1000):
        num -= 1000;
        ret = ret + "M"
    h = huns[num/100]
    num = num%100
    t = tens[num/10]
    num = num%10
    o = ones[num]
    print ret + h + t + o
test_cases.close();

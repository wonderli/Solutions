#!/usr/bin/env python
from __future__ import print_function
def enum_permutation(num_list, position, n):
    res = []
    if position == n - 1:
        for e in num_list:
            res.append(str(e))
        return res
    curr_list = num_list[:]
    for index in range(0, len(curr_list)):
        v = curr_list[index]
        del num_list[index]
        sublist = enum_permutation(num_list, position+1, n)
        for x in sublist:
            x_list = list(x)
            x_list.append(str(v))
            new_x = ''.join(x_list)
            res.append(new_x)
        num_list = curr_list[:]
    return res


if __name__ == '__main__':
    num = 5
    num_list = list(range(1,num+1))
    res = enum_permutation(num_list, 0, num)
    for e in res:
        a = list(e)
        for x in a:
            print(x, end=' ')
        print("", end='\n')
    print(len(res)) 

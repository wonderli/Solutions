#!/usr/bin/env python
import sys
def setCol(board, col, val):
    for i in range(0, r):
        board[i][col] = val
def setRow(board, row, val):
    for i in range(0, c):
        board[row][i] = val
def queryCol(board, col):
    ret = 0
    for i in range(0, r):
        ret += board[i][col]
    return ret
def queryRow(board, row):
    ret = 0
    for i in range(0, c):
        ret += board[row][i]
    return ret

c = 256
r = 256
board = [[0] * c for row in range(0, 256)]
test_cases=open(sys.argv[1], "r")
for test in test_cases:
    test  = test.strip("\n")
    ts = test.split(" ")
    cmd = ts[0]
    pos = int(ts[1])
    val = 0
    if len(ts) > 2:
        val = int(ts[2])
    if cmd == "SetCol":
        setCol(board, pos, val)
    elif cmd == "SetRow":
        setRow(board, pos, val)
    elif cmd== "QueryRow":
        print queryRow(board, pos)
    elif cmd== "QueryCol":
        print queryCol(board, pos)

test_cases.close()

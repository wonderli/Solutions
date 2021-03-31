#!/usr/bin/env python
import sys
import json
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    test = test.strip('\n')
    if test == '' :
        continue
    p = json.loads(test)
    print sum(item['id'] for item in p['menu']['items'] if item and 'label' in item)

test_cases.close()

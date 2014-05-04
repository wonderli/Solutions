#!/bin/bash
path_to_apue_src=/Users/xli/workspace/Solutions/APUE/apue
src=$1
gcc -I$path_to_apue_src/include $path_to_apue_src/lib/libapue.a $src

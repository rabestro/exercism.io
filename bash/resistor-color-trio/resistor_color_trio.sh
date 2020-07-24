#!/usr/bin/env bash

declare -A colors=(["black"]=0 ["brown"]=1 ["red"]=2 ["orange"]=3 ["yellow"]=4
  ["green"]=5 ["blue"]=6 ["violet"]=7 ["grey"]=8 ["white"]=9)

a=${colors[$1]}

if [ -z "$a" ]; then
  echo "Invalid first color"
  exit 1
fi

b=${colors[$2]}

if [ -z "$b" ]; then
  echo "Invalid second color"
  exit 1
fi

c=${colors[$3]}

if [ -z "$c" ]; then
  echo "Invalid third color"
  exit 1
fi

echo "$a$b ohms"
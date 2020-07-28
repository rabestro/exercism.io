#!/usr/bin/env bash

validate() {
  if [[ -z "$1" ]]; then
    echo "invalid colour" >&2
    exit 1
  fi
}

declare -A colors=(["black"]=0 ["brown"]=1 ["red"]=2 ["orange"]=3 ["yellow"]=4
  ["green"]=5 ["blue"]=6 ["violet"]=7 ["grey"]=8 ["white"]=9)

suffix=(" ohms" "0 ohms" "00 ohms" " kiloohms")

a=${colors[$1]}
validate "$a"

b=${colors[$2]}
validate "$b"

c=${colors[$3]}
validate "$c"

echo "$a$b${suffix[$c]}"

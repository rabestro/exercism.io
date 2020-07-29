#!/usr/bin/env bash

readonly array=("$@")
readonly target=$1

left=1
right=${#array[@]}
((right--))

echo "$right"

echo "${array[@]}"

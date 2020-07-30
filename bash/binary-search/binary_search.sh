#!/usr/bin/env bash

readonly target=$1
shift
readonly array=("$@")

left=-1
right=${#array[@]}

while ((left < right)); do
  mid=$(((left + right) / 2))
#  echo "[$left ($mid) $right]"
  if ((array[mid] > target)); then
    right=$mid
  elif ((array[mid] < target)); then
    left=$mid
  else
    left=$mid
    right=$mid
  fi
done

echo $((mid))
#echo "${array[@]}"

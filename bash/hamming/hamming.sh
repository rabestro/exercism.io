#!/usr/bin/env bash

if (($# != 2)); then
  echo "Usage: hamming.sh <string1> <string2>"
  exit 1
fi

declare -r left=$1
declare -r right=$2

if ((${#left} != ${#right})); then
  echo "left and right strands must be of equal length"
  exit 1
fi

declare -i difference=0

for ((i = 0; i < ${#left}; i++)); do
  [[ ${left:$i:1} != "${right:$i:1}" ]] && ((difference++))
done

echo "$difference"

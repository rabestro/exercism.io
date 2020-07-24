#!/usr/bin/env bash

if [[ "$#" -ne 2 ]]; then
  echo "Usage: hamming.sh <string1> <string2>"
  exit 1
fi

first=$1
second=$2

if [[ "${#first}" -ne "${#second}" ]]; then
  echo "left and right strands must be of equal length"
  exit 1
fi

echo "0"
#!/usr/bin/env bash

readonly cell=$1
if ((cell < 1 || cell > 64)); then
  echo "Error: invalid input"
  exit 1
fi
grains=$((1 << cell - 1))
echo $grains

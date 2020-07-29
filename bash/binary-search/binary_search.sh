#!/usr/bin/env bash

readonly array=("$@")
readonly target=$1

echo "${array[@]}"

echo "${array[0]}"
echo "${array[1]}"
echo "${array[2]}"

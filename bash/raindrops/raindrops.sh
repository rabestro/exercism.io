#!/usr/bin/env bash

sound=""

if [[ $1%3 -eq 0 ]]; then
  sound=Pling
fi

if [[ -z $sound ]]; then
  sound=$1
fi

echo "$sound"

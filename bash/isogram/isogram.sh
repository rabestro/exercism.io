#!/usr/bin/env bash

if [[ $1 =~ ([a-z]).*\1 ]]; then
  echo false
else
  echo true
fi

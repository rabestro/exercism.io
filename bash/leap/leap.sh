#!/usr/bin/env bash

if [ $(( $1%4 )) -eq 0 ]; then
  echo true
else
  echo false
fi
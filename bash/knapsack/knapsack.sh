#!/usr/bin/env bash
#
# Copyright (c) 2023 Jegors Čemisovs
# License: Apache-2.0 license
#
# Knapsack problem solution
#
# Usage: knapsack.sh max_weight [items ...]
# where: items look like "weight:value"
# example:
#       knapsack.sh 10 5:10 4:40 6:30 4:50
# should return:
#       90
#
arguments() {
  (($# == 0)) && exit 1

  printf "%d\n" "$1"; shift
  printf "%d\n" $#
  while (($# > 0))
  do printf "%d\n%d\n" "${1%:*}" "${1#*:}"; shift
  done
}

arguments "$@" | bc knapsack.bc

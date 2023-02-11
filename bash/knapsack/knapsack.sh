#!/usr/bin/env bash

(($# == 0)) && exit 1

arguments() {
  printf "%d\n" "$1"; shift
  printf "%d\n" $#
  while (($# > 0))
  do printf "%d\n%d\n" "${1%:*}" "${1#*:}"; shift
  done
}

arguments "$@" | bc knapsack.bc

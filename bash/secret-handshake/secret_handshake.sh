#!/usr/bin/env bash

function join_by() {
  local IFS="$1"
  shift
  echo "$*"
}

handshake=("wink" "double blink" "close your eyes" "jump")
code=$1
result=()

is_reverse=((code & 16==1))
echo $is_reverse

for i in {0..3}; do
  if ((code % 2 == 1)); then
    result+=("${handshake[$i]}")
  fi
  ((code /= 2))
done

join_by , "${result[@]}"


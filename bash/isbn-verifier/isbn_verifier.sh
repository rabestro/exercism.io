#!/usr/bin/env bash

false() {
  echo "false"
  exit 0
}

main() {
  local isbn=${1//-/}
  [[ $isbn =~ ^[[:digit:]]{9}[[:digit:]X]$ ]] || false

  local -i sum=$((${isbn: -1} == "X" ? 10 : ${isbn: -1}))
  local -i i=10
  while ((i > 1)); do
    ((sum += ${isbn: -i:1} * i--))
  done

  ((sum % 11)) && false
  echo "true"
}

main "$@"

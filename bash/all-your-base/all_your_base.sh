#!/usr/bin/env bash

main() {
  local -ir source_base="$1"
  local -ir target_base="$3"
  local -ar digits=($2)
  local -i power="${#digits[@]}"
  local -i number=0
  local -i digit

  for digit in "${digits[@]}"; do
    (( number += source_base ** --power * digit ))
  done
  echo "$number"

}

main "$@"

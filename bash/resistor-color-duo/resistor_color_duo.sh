#!/usr/bin/env bash

trap "exit 1" TERM
export TOP_PID=$$

color_number() {
  declare -A colors=(
    ["black"]=0 ["brown"]=1 ["red"]=2 ["orange"]=3 ["yellow"]=4
    ["green"]=5 ["blue"]=6 ["violet"]=7 ["grey"]=8 ["white"]=9
  )

  number=${colors[$1]}

  if [[ -z $number ]]; then
    echo "invalid color"
    kill -s TERM $TOP_PID
  fi
  echo "$number"
}

echo "$(color_number "$1")$(color_number "$2")"

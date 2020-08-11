#!/usr/bin/env bash

readonly sentence=${1//[!a-zA-Z?]/}

if [[ $1 =~ ^[[:space:]\\t\\n]*$ ]]; then
  echo "Fine. Be that way!"
elif [[ ${#sentence} -gt 1 && $sentence == "${sentence^^}" && $sentence =~ \?$ ]]; then
  echo "Calm down, I know what I'm doing!"
elif [[ $sentence =~ \?$ ]]; then
  echo "Sure."
elif [[ ${#sentence} -gt 0 && $sentence == "${sentence^^}" ]]; then
  echo "Whoa, chill out!"
else
  echo "Whatever."
fi

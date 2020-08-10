#!/usr/bin/env bash

#isQuestion=[[ $1 =~ "\?$" ]]
readonly sentence=${1//[!a-zA-Z?]/}

#echo "$isQuestion"

if [[ $sentence == "${sentence^^}" ]]; then
  isUpper=true
else
  isUpper=false
fi

if [[ -z $1 ]]; then
  echo "Fine. Be that way!"
elif [[ ${#sentence} -gt 1 && $sentence == "${sentence^^}" && $sentence =~ \?$ ]]; then
  echo "Calm down, I know what I'm doing!"
elif [[ ${#sentence} -gt 0 && $sentence == "${sentence^^}" ]]; then
  echo "Whoa, chill out!"
elif [[ $sentence =~ \?$ ]]; then
  echo "Sure."
else
  echo "Whatever."
fi

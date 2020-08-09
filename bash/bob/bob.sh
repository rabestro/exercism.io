#!/usr/bin/env bash

readonly sentence=${1//[!a-zA-Z]/}

if [[ $sentence =~ "\?$" ]]; then
  isQuestion=true
else
  isQuestion=false
fi

if [[ $sentence == "${sentence^^}" ]]; then
  isUpper=true
else
  isUpper=false
fi

if [[ -z $sentence ]]; then
  echo "Fine. Be that way!"
elif [[ $sentence == "${sentence^^}" ]]; then
  echo "Whoa, chill out!"
else
  echo "Whatever."
fi

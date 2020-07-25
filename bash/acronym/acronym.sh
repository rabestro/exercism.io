#!/usr/bin/env bash

phrase=$1
re="([a-zA-z])[a-zA-Z']*(.*)"
echo "Phrase: $phrase"
echo "RegExp: $re"
acronym=""
[[ $phrase =~ $re ]] && echo true

while [[ $phrase =~ $re ]]; do
  acronym=${acronym}${BASH_REMATCH[1]}
  phrase=${BASH_REMATCH[2]}
  echo "Phrase: $phrase Acronym: $acronym"
done

echo "$acronym"

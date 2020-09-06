#!/usr/bin/env bash

readonly number=${1//[[:blank:]]/}

if ! [[ $$number =~ ^[[:digit:]]{2,}$ ]]; then
  echo false
  exit 0
fi


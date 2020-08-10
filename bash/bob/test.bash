#!/usr/bin/env bash

if [[ $1 =~ ^[[:space:]\\t\\n]*$ ]]
then
   echo "is match"
else
   echo "is NOT match"
fi
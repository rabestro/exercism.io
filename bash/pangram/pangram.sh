#!/usr/bin/env bash

sentence=$1

unique=$(echo "$sentence" | grep -o . | sort | uniq)
echo "$unique"
#echo false
# tr -s [:lower:] [:upper:] | sed 's/[^a-zA-Z]//g' | grep -o . | sort | uniq

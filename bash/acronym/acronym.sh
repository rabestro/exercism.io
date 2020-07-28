#!/usr/bin/env bash

echo "$1" | sed 's/\([[:alpha:]]\)[a-zA-Z]*[^a-zA-Z]*/\1/g'


#!/usr/bin/env bash

readonly cell=$1
grains=$((1<<cell-1))
echo $grains
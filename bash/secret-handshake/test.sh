#!/usr/bin/env bash

readonly code=$1

#((code >> 4)) && range="3 -1 0" || range="0 3"
range=$(( 1 == 1 ? ({3..0..-1}) : ({0..3}) ))

echo $range

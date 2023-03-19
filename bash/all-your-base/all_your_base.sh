#!/usr/bin/env bash

main () {
    local -ir ibase="$1"
    local -ir obase="$3"
    local -r number=${2// /}

    echo "ibase=$ibase; obase=$obase; $number" | bc
}

main "$@"

#!/usr/bin/env bash

main () {
    local -i x=$1
    local -i y=$2
    local direction=${3:-north}

    echo $x $y $direction
}

main "$@"

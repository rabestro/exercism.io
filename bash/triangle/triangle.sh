#!/usr/bin/env bash

validate_triangle () {
    if (( $1 == 0 || $2 == 0 || $3 == 0 ))
    then
        echo "false"
        exit
    fi
}

is_equilateral () {
    [[ $1 == $2 && $2 == $3 ]] && echo "true" || echo "false"
}

main () {
    local -r triangle="$1"
    shift
    validate_triangle "$@"
    case "$triangle" in
        equilateral) is_equilateral "$@" ;;
    esac
}

main "$@"

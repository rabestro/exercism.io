#!/usr/bin/env bash

main () {
    local -ir MINUTES_IN_DAY=$(( 60 * 24 ))
    local -ir delta="$3$4"
    local -ir total_minutes=$(( MINUTES_IN_DAY + $1 % 24 * 60 + $2 % MINUTES_IN_DAY + delta % MINUTES_IN_DAY ))
    local -ir hours=$(( total_minutes / 60 % 24 ))
    local -ir minutes=$(( total_minutes % 60 ))
    printf "%02d:%02d\n" $hours $minutes
}

main "$@"

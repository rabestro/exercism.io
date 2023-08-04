#!/usr/bin/env bash

main () {
    local -i x=$1
    local -i y=$2
    local direction=${3:-north}
    local movements=$4

    for (( i=0; i<${#movements}; i++ )); do
        case ${movements:$i:1} in
            'A') case $direction in
                    'north') ((y++)) ;;
                    'east') ((x++)) ;;
                    'south') ((y--)) ;;
                    'west') ((x--)) ;;
                  esac ;;
            'R') case $direction in
                    'north') direction=east ;;
                    'east') direction=south ;;
                    'south') direction=west ;;
                    'west') direction=north ;;
                  esac ;;
            'L') case $direction in
                    'north') direction=west ;;
                    'east') direction=north ;;
                    'south') direction=east ;;
                    'west') direction=south ;;
                  esac ;;
        esac
    done

    echo $x $y $direction
}

main "$@"

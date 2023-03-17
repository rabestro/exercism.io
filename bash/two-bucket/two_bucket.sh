#!/usr/bin/env bash

(( $1 < $3 && $2 < $3 )) && echo "invalid goal" && exit 1

declare Source Target
declare -ir Goal="$3"
declare -A Volume=( [one]="$1" [two]="$2" )
declare -A Water=( [one]=0 [two]=0 )
declare -a History
declare -i Step=0

is_empty () {
    debug "is_empty $1 "
    [[ ${Water[$1]} == 0 ]]
}

is_full () {
    [[ ${Water[$1]} == ${Volume[$1]} ]]
}

is_goal () {
     debug "is_goal $1"
     echo "${Water[$1]} == $Goal" >> log.txt
     (( Water[$1] == Goal )) && echo "true" >> log.txt
     (( Water[$1] == Goal ))
}

fill () {
    debug "fill $1 "
    (( Water[$1] = Volume[$1] ))
}

empty () {
    (( Water[$1] = 0 ))
}

pouring () {
    debug "pouring"
    local -ir free_volume=$(( Volume[$Target] - Water[$Target] ))
    local -ir pouring_volume=$(( Water[$Source] < free_volume ? Water[$Source] : free_volume ))

    echo "f=$free_volume, p=$pouring_volume" >> log.txt

    (( Water[$Source] -= pouring_volume ))
    (( Water[$Target] += pouring_volume ))
}

process_step() {
    debug process_step
    if is_empty $Source
    then
        fill $Source
    elif (( Volume[$Target] == Goal ))
    then
        fill $Target
    elif is_full $Target
    then
        empty $Target
    else
        pouring
    fi
}

state () {
    echo "["${Water[$Source]}","${Water[$Target]}"]"
}

debug () {
    echo "--> $1 " "["${Water[$Source]}","${Water[$Target]}"]" >> log.txt
}

record_step () {
    local -r state="["${Water[$Source]}","${Water[$Target]}"]"
    debug record_step
    if [[ "${History[@]}" =~ "${state}" ]]
    then
        echo "invalid goal ..." "${History[@]}" " State: " "${state}" >> log.txt
        echo $Source $Target
        exit 1
    else
        History+=( "$state" )
    fi
}

main () {
    if [[ $4 == "one" ]]
    then
        Source=one
        Target=two
    else
        Source=two
        Target=one
    fi

    until (( Water[one] == Goal || Water[two] == Goal ))
    do
        process_step
        record_step
    done

    local winner second
    if is_goal one
    then
        winner=one
        second=two
    else
        winner=two
        second=one
    fi
    printf "moves: %d, goalBucket: %s, otherBucket: %d" $((${#History} - 1)) $winner ${Water[$second]}
}

main "$@"

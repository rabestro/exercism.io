#!/usr/bin/env bash
# alias gawk="~/go/bin/goawk"
# export gawk

for exercise in $(ls -d1 */)
do
    cd "$exercise"
    printf "Exercise %s\n" "$(head -1 README.md)"
    test=$(ls test-*.bats)
    bats "$test"
    cd ..
done

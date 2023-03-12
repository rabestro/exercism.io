#!/usr/bin/env bash

for exercise in $(ls -d1 */)
do
    cd "$exercise"
    test=$(ls test-*.bats)
    gsed --in-place 's|run ~/go/bin/goawk|run gawk|' "$test"
    cd ..
done

#!/usr/bin/env bash

for exercise in $(ls -d1 */)
do
    cd "$exercise"
    test=$(ls test-*.bats)
    gsed --in-place 's|run gawk|run ~/go/bin/goawk|' "$test"
    cd ..
done

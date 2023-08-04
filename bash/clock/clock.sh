
main () {
    local -i total_minutes=$(( $1*60 + $2 ))
    if (( total_minutes < 0 )); then
        (( total_minutes = 60 * 24 + total_minutes % 60 ))
    fi
    local -ir hours=$(( total_minutes / 60 % 24 ))
    local -ir minutes=$(( total_minutes % 60 ))
    printf "%02d:%02d" $hours $minutes
}

main "$@"

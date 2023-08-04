
main () {
    local -ir total_minutes=$(( $1*60 + $2 ))
    local -ir hours=$(( total_minutes / 60 % 24 ))
    local -ir minutes=$(( total_minutes % 60 ))
    printf "%02d:%02d" $hours $minutes
}

main "$@"

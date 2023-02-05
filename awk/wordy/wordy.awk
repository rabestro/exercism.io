BEGIN {
#    FPAT = "-?[[:digit:]]+|plus|minus|(multiplied|divided) by"
    FPAT = "-?[[:digit:]]+|[[:lower:]]{4,}( by)?"
}
function die(message) {print message > "/dev/stderr"; exit 1}

/^What is/ {
#    print $1, $2, $3
    for (i = 2; i <= NF; ++i) {
        operand = $i
        ++i
        switch (operand) {
            case "plus": $1 += $i; break
            case "minus": $1 -= $i; break
            case "multiplied by": $1 *= $i; break
            case "divided by": $1 /= $i; break
            default: die("unknown operation")
        }
    }
    print $1
}

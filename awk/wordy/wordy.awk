BEGIN {
    FPAT = "-?[[:digit:]]+|[[:lower:]]{4,}( by)?"
}
!/^What is/ {
    die("unknown operation")
}
/^What is/ {
#    print $1, $2, $3
    for (i = 2; i <= NF; ++i) {
        operand = $i

        if (operand !~ /plus|minus|multiplied by|divided by/)
            die("unknown operation")

        if (++i > NF) die("syntax error")

        switch (operand) {
            case "plus": $1 += $i; break
            case "minus": $1 -= $i; break
            case "multiplied by": $1 *= $i; break
            case "divided by": $1 /= $i; break
            default: die("unknown operation")
        }
    }
    if ($1 !~ /-?[[:digit:]]+/) die("syntax error")
    print $1
}

function die(message) {print message > "/dev/stderr"; exit 1}

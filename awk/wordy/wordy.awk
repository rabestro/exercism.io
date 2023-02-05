BEGIN {
    FPAT = "-?[[:digit:]]+|plus|minus|(multiplied|divided) by"
}

/What is -?[[:digit:]]+( (plus|minus|multiplied by|divided by) -?[[:digit:]]+)*\?/ {
    for (i = 2; i <= NF; ++i) {
        operand = $i
        ++i
        switch (operand) {
            case "plus": $1 += $i; break
            case "minus": $1 -= $i; break
            case "multiplied by": $1 *= $i; break
            case "divided by": $1 /= $i; break
        }
    }
    print $1
}

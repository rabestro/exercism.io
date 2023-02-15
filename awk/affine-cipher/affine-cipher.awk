BEGIN {
    FS = "|"
    Alphabet = "abcdefghijklmnopqrstuvwxyz"
    M = length(Alphabet)
}
$1 == "encode" {
#    phrase = $4
    for (i = 1; i <= length($4); ++i) {
        symbol = substr($4, i, 1)
        if (symbol !~ /[[:alnum:]]/) continue
        if (out && (1 + length(out)) % 6 == 0) out = out " "
        out = out E(symbol)
    }
    print out
}

function E(x,   i,e) {
    if (x ~ /[[:digit:]]/) return x
    i = index(Alphabet, tolower(x)) - 1
    e = 1 + ($2 * i + $3) % M
    return substr(Alphabet, e, 1)
}

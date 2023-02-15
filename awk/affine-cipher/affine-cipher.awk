BEGIN {
    FS = "|"
    Alphabet = "abcdefghijklmnopqrstuvwxyz"
    M = length(Alphabet)
}

!coprime() {
    print "a and m must be coprime."; exit 1
}

$1 == "encode" {
    for (i = 1; i <= length($4); ++i) {
        symbol = substr($4, i, 1)
        if (symbol !~ /[[:alnum:]]/) continue
        if (out && (1 + length(out)) % 6 == 0) out = out " "
        out = out E(symbol)
    }
    print out
}

$1 == "decode" {
    for (i = 1; i <= length($4); ++i) {
        symbol = substr($4, i, 1)
        if (symbol !~ /[[:alnum:]]/) continue
        out = out D(symbol)
    }
    print out
}

function E(x,   i,e) {
    if (x ~ /[[:digit:]]/) return x
    i = index(Alphabet, tolower(x)) - 1
    e = 1 + ($2 * i + $3) % M
    return substr(Alphabet, e, 1)
}
function D(y,   i,e) {
    if (y ~ /[[:digit:]]/) return y
    i = index(Alphabet, tolower(y)) - 1
    e = ($2^-1)(i - $3) % M
    return substr(Alphabet, e, 1)
}
function coprime() {return gcd($2, M)==1}
function gcd(p,q){return(q?gcd(q,(p%q)):p)}

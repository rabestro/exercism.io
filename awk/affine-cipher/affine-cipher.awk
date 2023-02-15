BEGIN {
    FS = "|"
    Alphabet = "abcdefghijklmnopqrstuvwxyz"
    M = length(Alphabet)
}
{
    a = $2
    b = $3
    print M
}

function encode() {

}

function E(x,   i,e) {
    if (x ~ /[[:digit:]]/) return x
    i = index(Alphabet, tolower(x)) - 1
    e = 1 + ($2 * i + $3) % M
    return substr(Alphabet, e, 1)
}

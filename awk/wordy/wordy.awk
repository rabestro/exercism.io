BEGIN {
    FPAT = "-?[[:digit:]]+"
}
NF == 1 {
    print $1
}
/What is -?[[:digit:]]+ plus -?[[:digit:]]+/ {
    print $1 + $2
}
/What is -?[[:digit:]]+ minus -?[[:digit:]]+/ {
    print $1 - $2
}
/What is -?[[:digit:]]+ multiplied by -?[[:digit:]]+/ {
    print $1 * $2
}

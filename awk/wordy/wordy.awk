BEGIN {
    FPAT = "-?[[:digit:]]+"
}
NF == 1 {
    print $1
}
/What is -?[[:digit:]]+ plus -?[[:digit:]]+/ {
    print $1 + $2
}

# These variables are initialized on the command line (using '-v'):
# - flags
# - pattern

BEGIN {
    IGNORECASE = flags ~ "i"
    if (flags ~ "x") pattern = "^"pattern"$"
}
($0 ~ pattern) != (flags ~ "v") {
    Success = 1
    if (flags ~ "l") {
        print FILENAME
        nextfile
    }
    print flags ~ "n" ? NR":"$0 : $0
}
END {
    if (!Success) exit 1
}

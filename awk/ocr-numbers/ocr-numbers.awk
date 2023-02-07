BEGIN {
    RS = ""
    FS = "\n"
}
NF != 4 {
    die("Number of input lines is not a multiple of four")
}
length($1) % 3 {
    die("Number of input columns is not a multiple of three")
}
{
    print digit(0)
}

function digit(i,   text) {
    text = substr($1, i, 3) substr($2, i, 3) substr($3, i, 3)
    switch (text) {
        case " _ | ||_|": return 0
        case "     |  |": return 1
        case " _  _||_ ": return 2
        case " _  _| _|": return 3
        default: return "?"
    }
}

function die(message) {print message > "/dev/stderr"; exit 1}

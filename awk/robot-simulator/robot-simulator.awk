# These variables are initialized on the command line (using '-v'):
# - x
# - y
# - dir

BEGIN {
    x = +x; y = +y; dir = dir ? dir : "north"
}

END {
    print x, y, dir
}

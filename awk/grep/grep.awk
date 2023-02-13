# These variables are initialized on the command line (using '-v'):
# - flags
# - pattern

BEGIN {

}
$0 ~ pattern {
    print
}

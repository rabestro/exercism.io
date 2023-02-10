BEGIN {

}
/^[0-7] [0-7] [0-7] [0-7]/ && ($1 != $3 || $2 != $4) {
    next
}
{
    print "invalid"; exit 1
}

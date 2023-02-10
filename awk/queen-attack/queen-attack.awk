BEGIN {

}
/^([0-7] ){3}[0-7]/ && ($1 != $3 || $2 != $4) {
    print canAttack() ? "true" : "false"
    next
}
{
    print "invalid"; exit 1
}

function canAttack() {
    return $1 == $3 || $2 == $4
}

# These variables are initialized on the command line (using '-v'):
# - action
# - grade

BEGIN {
    OFS = FS = ","
}
{
    Students[$1] = $2
}
END {
    @action()
}

function roster(   student) {
    NF = 0
    for (student in Students) $(++NF) = student
    print
}

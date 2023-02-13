# These variables are initialized on the command line (using '-v'):
# - len

BEGIN {
    FPAT = "[[:digit:]]+|."
}
{
    print @type()
    #    print NF
}
function encode(   i,previous,count,out) {
    for (i = 1; i <= NF; ++i) {
        if (previous == $i) {
            ++count
            continue
        }
        out = out (count > 1 ? count : "") previous
        previous = $i
        count = 1
    }
    out = out (count > 1 ? count : "") previous
    return out
}

function decode(   out,i,n) {
    for (i = 1; i <= NF; ++i) {
        if ($i ~ /[[:digit:]]+/) {
            n = $(i++)
        } else n = 1
        while (n-- > 0) out = out $i
    }
    return out
}

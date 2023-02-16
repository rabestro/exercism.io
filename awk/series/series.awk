@include "assert"

{
    assert($0, "series cannot be empty")
    assert(len > 0 && len <= length($0), "invalid length")

    n = $0
    while (i++ <= length(n) - len)
        $i = substr(n, i, len)
    print
}

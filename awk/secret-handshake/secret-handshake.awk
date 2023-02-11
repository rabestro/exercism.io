BEGIN {
    OFS = ","
    Code[1] = "wink"
    Code[2] = "double blink"
    Code[4] = "close your eyes"
    Code[8] = "jump"
}
{
    signal = $1
    reversed = and(signal, 16)

    NF = 0
    for (code in Code) if (and(signal, code)) $(++NF) = Code[code]
    print
}
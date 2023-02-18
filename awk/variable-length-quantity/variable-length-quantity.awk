# These variables are initialized on the command line (using '-v'):
# - action

{
    for (i = 1; i <= NF; ++i) {
        $i = encode_number(strtonum("0x"$i))
    }
    print
}
function encode_number(number,   out,hex,format) {
    do {
        hex = out ? 128 : 0
        hex += number % 128
        format = (hex < 17 ? "0" : "") "%X" (out ? " " : "")
        out = sprintf(format, hex) out
        number = int(number / 128)
    } while(number)

    return out
}

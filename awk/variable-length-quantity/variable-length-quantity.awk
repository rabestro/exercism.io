# These variables are initialized on the command line (using '-v'):
# - action

action == "encode" {
    for (i = 1; i <= NF; ++i) $i = encode($i)
    print
}

action == "decode" {
    sequnce = $0
    print
}

action !~ /(en|de)code/ {
    print "unknown action"
    exit 1
}

function encode(number,   out,hex,format) {
    number = strtonum("0x"number)
    do {
        hex = out ? 128 : 0
        hex += number % 128
        format = (hex < 17 ? "0" : "") "%X" (out ? " " : "")
        out = sprintf(format, hex) out
        number = int(number / 128)
    } while(number)

    return out
}

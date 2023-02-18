# These variables are initialized on the command line (using '-v'):
# - action

BEGIN {
    A["0"]="0000"
    A["1"]="0001"
    A["2"]="0010"
    A["3"]="0011"
    A["4"]="0100"
    A["5"]="0101"
    A["6"]="0110"
    A["7"]="0111"
    A["8"]="1000"
    A["9"]="1001"
    A["A"]="1010"
    A["B"]="1011"
    A["C"]="1100"
    A["D"]="1101"
    A["E"]="1110"
    A["F"]="1111"
}
{
    n = strtonum("0x"$1)
    print encode_number(n)
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

BEGIN {
    PROCINFO["sorted_in"] = "@ind_num_asc"

    NumeralCount = split("M CM D CD C XC L XL X IX V IV I", RomanNumerals)
    split("1000 900 500 400 100 90 50 40 10 9 5 4 1", ArabicNumerals)

#    numerals[1] = "I"
#    numerals[4] = "IV"
#    numerals[5] = "V"
#    numerals[9] = "IX"
#    numerals[10] = "X"
#    numerals[40] = "XL"
#    numerals[50] = "L"
#    numerals[90] = "XC"
#    numerals[100] = "C"
#    numerals[400] = "CD"
#    numerals[500] = "D"
#    numerals[900] = "CM"
#    numerals[1000] = "M"

}
{
    print toRomanNumeral($0)
}

function toRomanNumeral(number, i, roman) {
    for (i = 1; i <= NumeralCount; ++i) {
        while (ArabicNumerals[i] <= number) {
            number -= ArabicNumerals[i]
            roman = roman RomanNumerals[i]
        }
    }
    return roman
}
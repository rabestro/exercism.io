//
// Function to convert from normal numbers to Roman Numerals.
//

export const toRoman = (number) => {
    return ["", "M", "MM", "MMM"][Math.floor(number / 1000)]
        + ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"][Math.floor(number % 1000 / 100)]
        + ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"][Math.floor(number % 100 / 10)]
        + ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"][number % 10];
};

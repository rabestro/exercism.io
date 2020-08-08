//
// Function to convert from normal numbers to Roman Numerals.
//

export const toRoman = (number) => {
    return ["", "C", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"][Math.floor(number % 1000 / 100)]
        + ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"][Math.floor(number % 100 / 10)]
        + ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"][number % 10];
};

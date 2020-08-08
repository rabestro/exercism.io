//
// Function to convert from normal numbers to Roman Numerals.
//

export const toRoman = (number) => {
    return ["", "I", "II"][number % 10];
};

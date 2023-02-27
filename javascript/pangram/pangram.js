// Benchmark: https://jsben.ch/oOHKq

const A_LCASE = 97;
const A_UCASE = 65;
const Z_LCASE = 122;
const Z_UCASE = 90;
const ALL_26_BITS_SET = 67108863;

export function isPangram(phrase) {
    let set = 0;
    for (let i = phrase.length; i-- > 0;) {
        const c = phrase.charCodeAt(i);
        if (c >= A_UCASE && c <= Z_UCASE) set |= 1 << c - A_UCASE;
        else if (c >= A_LCASE && c <= Z_LCASE) set |= 1 << c - A_LCASE;
        if (set === ALL_26_BITS_SET) return true;
    }
    return false;
}

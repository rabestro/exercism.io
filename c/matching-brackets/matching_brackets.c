#include "matching_brackets.h"

/**
 * Given a string containing brackets [], braces {},
 * parentheses (), or any combination thereof, verify
 * that any and all pairs are matched and nested correctly.
 *
 * @param input string containing brackets, braces and parentheses
 * @return true if matched and nested correctly
 */
bool is_paired(const char *input) {
    unsigned long long brackets = 0;
    unsigned long long braces = 0;
    unsigned int index = 0;

    for (const char *c = input; *c; ++c) {
        bool is_matched;
        switch (*c) {
            case '[':
                brackets |= 1ull << index++;
                continue;
            case '(':
                brackets |= 1ull << index;
            case '{':
                braces |= 1ull << index++;
                continue;
            case ']':
                is_matched = index && (brackets & (1ull << --index)) && !(braces & (1ull << index));
                break;
            case '}':
                is_matched = index && (braces & (1ull << --index)) && !(brackets & (1ull << index));
                break;
            case ')':
                is_matched = index && (brackets & (1ull << --index)) && (braces & (1ull << index));
                break;
            default:
                continue;
        }
        if (!is_matched) return false;
        const unsigned long long mask = (1ull << index) - 1;
        brackets &= mask;
        braces &= mask;
    }
    return !index;
}

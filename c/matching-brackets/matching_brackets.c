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
    unsigned long long stack = 0;
    unsigned int index = 0;

    for (const char *c = input; *c; ++c) {
        bool is_matched;
        switch (*c) {
            case '[':
                stack |= 1 << index++;
                index++;
                continue;
            case '{':
                stack |= 1 << index;
            case '(':
                stack |= 1 << ++index;
                ++index;
                continue;
            case ']':
                is_matched = !(stack & (1 << --index)) && (stack & (1 << --index));
                break;
            case '}':
                is_matched = (stack & (1 << --index)) && (stack & (1 << --index));
                break;
            case ')':
                is_matched = (stack & (1 << --index)) && !(stack & (1 << --index));
                break;
            default:
                continue;
        }
        if (is_matched) stack &= (1 << index) - 1;
        else return false;
    }
    return !index;
}

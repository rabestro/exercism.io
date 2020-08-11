#include "pangram.h"
#include <stddef.h>
#include <ctype.h>
#include <stdint.h>

bool is_pangram(const char *sentence) {
    if (sentence == NULL) return false;
    uint32_t set = 0;
    for (const char *c = sentence; *c != '\0'; ++c) {
        if (isalpha(*c)) set |= 1 << (tolower(*c) - 'a');
    }
    return set == (1 << 26) - 1;
}
#include "pangram.h"
#include <stddef.h>
#include <ctype.h>
#include <stdint.h>

bool is_pangram(const char *sentence) {
    if (sentence == NULL) return false;
    uint32_t set = 0;
    while (*sentence != '\0') {
        if (isalpha(*sentence)) set |= 1 << (tolower(*sentence) - 'a');
    }
    return set == (1 << 27) - 1;
}
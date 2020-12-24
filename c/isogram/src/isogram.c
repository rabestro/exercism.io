#include "isogram.h"
#include <ctype.h>
#include <stdlib.h>

bool is_isogram(const char phrase[]) {
    if (phrase == NULL) return false;
    unsigned long set = 0;

    for (const char *c = phrase; *c != '\0'; ++c) {
        if (isalpha(*c)) {
            const unsigned long symbol = 1 << (tolower(*c) - 'a');
            if (set & symbol) return false;
            set |= symbol;
        }
    }
    return true;
}
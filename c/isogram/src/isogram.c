#include "isogram.h"
#include <ctype.h>
#include <stdlib.h>

bool is_isogram(const char phrase[]) {
    if (phrase == NULL) return false;

    unsigned long set = 0;
    bool repeating = false;

    for (const char *c = phrase; *c != 0; ++c) {
        char symbol = tolower(*c);
        if (isalpha(symbol)) {
            symbol -= 'a';
            repeating = set & (1 << symbol);
            if (repeating) break;
            set |= 1 << symbol;
        }
    }
    return !repeating;
}
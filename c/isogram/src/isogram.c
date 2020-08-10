#include "isogram.h"
#include <ctype.h>
#include <stdlib.h>

bool is_isogram(const char phrase[]) {
    if (phrase == NULL) return false;
    unsigned long set = 0;

    for (const char *c = phrase; *c != '\0'; ++c) {
        if (isalpha(*c)) {
            const char symbol = tolower(*c) - 'a';
            if (set & (1 << symbol)) return false;
            set |= 1 << symbol;
        }
    }
    return true;
}
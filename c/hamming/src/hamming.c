#include "hamming.h"
#include <stddef.h>

int compute(const char *lhs, const char *rhs) {
    if (lhs == NULL || rhs == NULL) return -1;

    int difference = 0;
    while (*lhs != '\0' && *rhs != '\0') {
        if (*lhs++ != *rhs++) ++difference;
    }
    return *lhs == *rhs ? difference : -1;
}
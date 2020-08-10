#include "hamming.h"

int compute(const char *lhs, const char *rhs) {
    int difference = 0;
    while (*lhs != '\0' && *rhs != '\0') {
        if (*lhs++ != *rhs++) ++difference;
    }
    return difference;
}
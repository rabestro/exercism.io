#include "armstrong_numbers.h"

bool is_armstrong_number(int candidate) {
    int power = 0;
    for (int i = candidate; i > 0; i /= 10) ++power;

    int sum = 0;
    for (int i = candidate; i > 0; i /= 10) {
        int digit = i % 10;
        int raised = 1;
        for (int i = power; i > 0; --i) raised *= digit;
        sum += raised;
    }
    return candidate == sum;
}
#!/usr/bin/env bash

bc <<< "
define digit(i) {
    return number % 10^i / 10^--i
}

number = $1
len = $2

max_index = length(number) - len + 1

for (i = 1; i <= max_index; ++i) {
    product = digit(i)
    for (k = 1; k < len; ++k) {
        product *= digit(i + k)
    }
    if (product > max_product) {
        max_product = product
    }
}

print max_product"

#include "resistor_color_trio.h"

int color_code(resistor_band_t *color) {
    return (int) *color * 100 + color[1] * 10 + color[3];
}